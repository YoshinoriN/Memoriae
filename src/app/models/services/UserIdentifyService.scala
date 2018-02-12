package memoriae.models.services

import javax.inject.Inject
import scala.concurrent.{ ExecutionContext, Future }
import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.services.IdentityService
import memoriae.models.UserIdentify
import memoriae.models.daos.UserDAO

trait UserIdentifyServiceTrait extends IdentityService[UserIdentify] {

  def retrieve(userName: String): Future[Option[UserIdentify]]

  def save(user: UserIdentify): Future[UserIdentify]

}

class UserIdentifyService @Inject() (userDAO: UserDAO)(implicit ex: ExecutionContext) extends UserIdentifyServiceTrait {

  def retrieve(userName: String) = userDAO.find(userName)

  def retrieve(loginInfo: LoginInfo): Future[Option[UserIdentify]] = userDAO.find(loginInfo)

  def save(user: UserIdentify) = userDAO.save(user)

}
