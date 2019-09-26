import org.scalatest._
import play.api.libs.json._

class JsonAnimalsSpec extends WordSpec with MustMatchers {
  import JsonAnimals._

  "animalFormat" must {
    "write an animal" in {
      Json.toJson[Animal](Dog("Sparky")) must equal(Json.obj(
        "type" -> "Dog",
        "name" -> "Sparky"
      ))
    }

    "read valid json" in {
      val insect = Insect(6)
      val json   = Json.obj(
        "type" -> "Insect",
        "legs" -> 6
      )

      Json.fromJson[Animal](json).asOpt must equal(Some(insect))
    }

    "read invalid json" in {
      val json = Json.obj("legs" -> 6)

      Json.fromJson[Animal](json) must equal {
        JsError(JsPath \ "type", "error.expected.animal.type")
      }
    }
  }
}