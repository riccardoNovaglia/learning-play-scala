import io.restassured.RestAssured
import io.restassured.RestAssured._
import io.restassured.parsing.Parser
import org.hamcrest.Matchers._
import org.scalatestplus.play._

/**
  * add your integration spec here.
  * An integration test will fire up a whole play application in a real (or headless) browser
  */
class IntegrationSpec extends PlaySpec with OneServerPerTest with OneBrowserPerTest with HtmlUnitFactory {
  RestAssured.port = port
  RestAssured.registerParser("text/plain", Parser.TEXT)

  "Application" should {

    "work from within a browser" in {

      go to ("http://localhost:" + port)

      pageSource must include("Your stuff is ready.")
    }

    "return some text when I call the greet endpoint" in {
      when
        .get("/greet")
      .then
        .statusCode(200)
        .body(equalTo("hello world"))
    }

    "return some json when I call the greetJson endpoint" in {
      when
        .get("/jsonGreet")
      .then
        .statusCode(200)
        .body("greet", equalTo("hello world"))
    }

    "return some serialized object" in {
      when
        .get("/jsonSerial")
      .then
        .statusCode(200)
        .body("greet", equalTo("hello world"))
    }
  }
}
