package memoriae.controllers

import javax.inject.Inject
import scala.concurrent.{ ExecutionContext, Future }
import play.api.i18n.{ I18nSupport, Messages }
import play.api.mvc.{ AbstractController, AnyContent, ControllerComponents, Request }
import play.api.data.Form
import play.api.data.Forms._
import controllers.AssetsFinder
import memoriae.utils.Logger

import AuthController._

object AuthController {
  case class SignInFormData(uid: String, password: String)

  val signInForm = Form(
    mapping(
      "uid" -> nonEmptyText,
      "password" -> nonEmptyText,
    )(SignInFormData.apply)(SignInFormData.unapply)
  )
}

class AuthController @Inject() (
  components: ControllerComponents
)(
  implicit
  assets: AssetsFinder,
  ex: ExecutionContext
) extends AbstractController(components) with I18nSupport with Logger {

  def view = TODO

  def signIn = TODO

  def signOut = TODO

}
