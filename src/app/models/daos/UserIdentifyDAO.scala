package memoriae.models.daos

import scala.concurrent.Future
import scala.concurrent.duration.{ Duration, _ }
import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import memoriae.models.UserIdentify
import memoriae.services.cache.UserAuthenticationCache
import memoriae.utils.Logger

class UserDAO extends UserDAOTrait with Logger {

  def find(loginInfo: LoginInfo) = {
    UserAuthenticationCache.cache.get[UserIdentify](loginInfo.providerKey) match {
      case Some(user) => Future.successful(Option(user))
      case None => {
        logger.info(securityMaker, s"Can not find authenticated information : ${loginInfo.providerKey}")
        Future.successful(None)
      }
    }
  }

  def find(userName: String) = Future.successful(UserAuthenticationCache.cache.get[UserIdentify](userName))

  def save(user: UserIdentify) = {
    //TODO: Set duration
    UserAuthenticationCache.cache.set(user.userName, user, Duration.Inf)
    Future.successful(user)
  }

}

trait UserDAOTrait {

  def find(loginInfo: LoginInfo): Future[Option[UserIdentify]]

  def find(userName: String): Future[Option[UserIdentify]]

  def save(user: UserIdentify): Future[UserIdentify]

}
