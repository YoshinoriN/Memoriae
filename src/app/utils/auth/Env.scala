package memoriae.utils.auth

import com.mohiva.play.silhouette.api.Env
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import memoriae.models.UserIdentify

trait JWTEnv extends Env {
  type I = UserIdentify
  type A = JWTAuthenticator
}
