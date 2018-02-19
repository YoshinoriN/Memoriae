package memoriae.services

import memoriae.models.Users
import memoriae.utils.Logger
import memoriae.utils.auth.BCryptPasswordEncoder

object UsersService extends QuillProvider with Logger {

  import ctx._;

  /**
   * Authenticate user.
   *
   * @param userName The user name to authenticate.
   * @param password The user's password
   * @return [[Users]]
   */
  def authenticate(userName: String, password: String): Option[Users] = {
    findUserByName(userName) match {
      case Some(user) => {
        if (BCryptPasswordEncoder.matches(password, user.password)) {
          Some(user)
        } else {
          None
        }
      }
      case _ => None
    }
  }

  /**
   * Find user by user name.
   *
   * @param userName The user name.
   * @return [[Users]]
   */
  def findUserByName(userName: String): Option[Users] = {
    run(query[Users].filter(u => u.userName == lift(userName) && u.deletedAt.isEmpty)).headOption
  }

  /**
   * Check existence administrator
   *
   * @return [[Boolean]]
   */
  def existsAdmin: Boolean = {
    val q = quote {
      query[Users].filter(u => u.isAdmin == true && u.deletedAt.isEmpty)
    }
    run(q).headOption match {
      case Some(_) => true
      case _ => false
    }
  }

  /**
   * Create default administrator if doesn't exists.
   */
  def createDefaultAdmin = {
    if (!existsAdmin) {
      val q = quote {
        query[Users].insert(
          _.userName -> lift("admin"),
          _.password -> lift(BCryptPasswordEncoder.encode("pass")),
          _.isAdmin -> lift(true),
          _.forcePasswordReset -> lift(true)
        )
      }
      run(q)
      logger.info("Created default administrator (user name is admin)")
    }
  }

}
