package memoriae.controllers

import javax.inject._
import play.api.i18n.I18nSupport
import play.api.mvc.{ AbstractController, AnyContent, ControllerComponents }
import controllers.AssetsFinder

@Singleton
class ApplicationController @Inject() (
  cc: ControllerComponents
)(
  implicit
  assets: AssetsFinder
) extends AbstractController(cc) with I18nSupport {

  def index() = Action { implicit request =>
    Ok(views.html.index())
  }
}
