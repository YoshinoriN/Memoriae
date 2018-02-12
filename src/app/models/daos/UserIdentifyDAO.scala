package memoriae.models.daos

import scala.concurrent.Future
import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }
import memoriae.models.UserIdentify
import memoriae.utils.Logger

class UserDAO extends UserDAOTrait with Logger {

  def find(loginInfo: LoginInfo) = {
    Future.successful(None)
  }

  def find(userName: String) = Future.successful(None)

  def save(user: UserIdentify) = {
    Future.successful(user)
  }

}

trait UserDAOTrait {

  def find(loginInfo: LoginInfo): Future[Option[UserIdentify]]

  def find(userName: String): Future[Option[UserIdentify]]

  def save(user: UserIdentify): Future[UserIdentify]

}
