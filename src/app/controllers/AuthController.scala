package memoriae.controllers

import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}
import play.api.i18n.{I18nSupport, Messages}
import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import play.api.data.Form
import play.api.data.Forms._
import com.mohiva.play.silhouette.api._
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.util.{PasswordHasherRegistry, PasswordInfo}
import com.mohiva.play.silhouette.impl.providers._
import com.mohiva.play.silhouette.api.actions.SecuredRequest
import controllers.AssetsFinder
import memoriae.services. { UsersService, UserIdentifyService }
import memoriae.models.UserIdentify
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
  components: ControllerComponents,
  userIdentifyService: UserIdentifyService,
  authInfoRepository: AuthInfoRepository,
  credentialsProvider: CredentialsProvider
)(
  implicit
  assets: AssetsFinder,
  ex: ExecutionContext
) extends AbstractController(components) with I18nSupport with Logger {

  def view = silhouette.UnsecuredAction.async { implicit request: Request[AnyContent] =>
    Future.successful(Ok(views.html.signIn(signInForm)))
  }

  def signIn = silhouette.UnsecuredAction.async { implicit request =>
    signInForm.bindFromRequest.fold(
      form => Future.successful(BadRequest(views.html.signIn(signInForm))),
      data => {
        try {
          UsersService.authenticate(data.username, data.password) match {
            case None => {
              logger.warn(securityMaker, s"Authentication Failed: ${data.username}")
              Future.successful(Redirect(routes.AuthController.view()).flashing("error" -> Messages("invalid.credentials")))
            }
            case Some(u) => {
              val loginInfo = LoginInfo(CredentialsProvider.ID, data.username)
              val userIdentify = UserIdentify(data.username, loginInfo, u.isAdmin)

              for {
                user <- userIdentifyService.save(userIdentify)
                authenticator <- silhouette.env.authenticatorService.create(loginInfo)
                value <- silhouette.env.authenticatorService.init(authenticator)
                result <- silhouette.env.authenticatorService.embed(value, Redirect(routes.ApplicationController.index()).flashing("success" -> Messages("valid.credentials")))
              } yield {
                silhouette.env.eventBus.publish(LoginEvent(user, request))
                logger.info(securityMaker, s"Authentication Succeeded: ${data.username}")
                result
              }
            }
          }
        } catch {
          case e: Exception =>
            logger.error(securityMaker, s"${e.getMessage}")
            Future.successful(Redirect(routes.AuthController.view()).flashing("error" -> Messages("exception")))
        }
      }
    )
  }

  def signOut = TODO

}
