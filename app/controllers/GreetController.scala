package controllers

import com.google.inject.{Inject, Singleton}
import play.api.mvc.{Action, Controller}

@Singleton
class GreetController @Inject() extends Controller {

  def helloWorld() = Action {
    Ok("hello world")
  }
}
