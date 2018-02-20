package memoriae.controllers

import javax.inject.Inject
import scala.concurrent.{ ExecutionContext, Future }
import play.api.i18n.{ I18nSupport, Messages }
import play.api.mvc.{ AbstractController, AnyContent, ControllerComponents, Request }
import play.api.data.Form
import play.api.data.Forms._
import com.mohiva.play.silhouette.api._
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.util.{ PasswordHasherRegistry, PasswordInfo }
import com.mohiva.play.silhouette.impl.providers._
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import controllers.AssetsFinder
import memoriae.utils.Logger
import memoriae.utils.auth.JWTEnv

import AuthController._

object AuthController {
  case class SignInFormData(username: String, password: String)

  val signInForm = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText,
    )(SignInFormData.apply)(SignInFormData.unapply)
  )
}

class AuthController @Inject() (
  silhouette: Silhouette[JWTEnv],
  components: ControllerComponents
)(
  implicit
  assets: AssetsFinder,
  ex: ExecutionContext
) extends AbstractController(components) with I18nSupport with Logger {

  def view = silhouette.UnsecuredAction.async { implicit request: Request[AnyContent] =>
    Future.successful(Ok(views.html.signIn(signInForm)))
  }

  def signIn = TODO

  def signOut = TODO

}
