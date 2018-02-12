package memoriae.models

import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }

case class UserIdentify(
  userName: String,
  loginInfo: LoginInfo,
  isAdmin: Boolean
) extends Identity
