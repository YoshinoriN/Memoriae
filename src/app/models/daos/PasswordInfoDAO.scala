package memoriae.models.daos

import javax.inject.Inject
import scala.concurrent.Future
import scala.concurrent.duration.{ Duration, _ }
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.cache._
import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.util.PasswordInfo
import com.mohiva.play.silhouette.persistence.daos.DelegableAuthInfoDAO

class PasswordInfoDAO @Inject() (
  cache: AsyncCacheApi
) extends DelegableAuthInfoDAO[PasswordInfo] {

  def add(loginInfo: LoginInfo, authInfo: PasswordInfo): Future[PasswordInfo] = {
    //TODO : Set duration from config
    cache.set(loginInfo.providerKey, PersistentAuthInfo(loginInfo, authInfo), Duration.Inf).map(_ => authInfo)
  }

  def save(loginInfo: LoginInfo, authInfo: PasswordInfo): Future[PasswordInfo] = {
    add(loginInfo, authInfo)
  }

  def update(loginInfo: LoginInfo, authInfo: PasswordInfo): Future[PasswordInfo] = {
    add(loginInfo, authInfo)
  }

  def remove(loginInfo: LoginInfo): Future[Unit] = {
    Future.successful(cache.remove(loginInfo.providerKey).map(_ => loginInfo))
  }

  def find(loginInfo: LoginInfo): Future[Option[PasswordInfo]] = {
    cache.get(loginInfo.providerKey)
  }

}

case class PersistentAuthInfo(
  loginInfo: LoginInfo,
  passwordInfo: PasswordInfo
)
