import java.util.Date
import play.api.libs.json._

object JsonMacroExercise {
  case class Message(
                      id: Option[Long],
                      posted: Date,
                      author: String,
                      text: String
                    )

  implicit val messageFormat: OWrites[Message] = Json.writes[Message]
  implicit val messageReads: Reads[Message] = Json.reads[Message]
}