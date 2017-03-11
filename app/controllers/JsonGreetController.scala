package controllers

import com.google.inject.{Inject, Singleton}
import play.api.libs.json.{JsValue, Json, Writes}
import play.api.mvc.{Action, Controller}

@Singleton
class JsonGreetController @Inject() extends Controller {

  implicit val GreetWrites = new Writes[Greet] {
    override def writes(greet: Greet): JsValue = Json.obj(
      "greet" -> greet.greet
    )
  }

  def jsonGreet() = Action {
    Ok(Json.obj("greet" -> "hello world"))
  }

  def jsonSerial() = Action {
    Ok(Json.toJson(Greet("hello world")))
  }
}


case class Greet(greet: String)
