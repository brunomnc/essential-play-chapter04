import play.api.libs.json._

object JsonLights {
  sealed trait TrafficLight
  final case object Red extends TrafficLight
  final case object Amber extends TrafficLight
  final case object Green extends TrafficLight

  // TODO: Complete:
  //  - Define a JSON format for `TrafficLight`:
  //     - Red is serialized as the number 0
  //     - Amber is serializes as the number 1
  //     - Green is serialized as the number 2
  implicit object trafficLightsFormat extends Format[TrafficLight] {
    override def writes(o: TrafficLight): JsValue = o match {
      case Red => JsNumber(0)
      case Amber => JsNumber(1)
      case Green => JsNumber(2)
      case _ => JsString("Invalid data")
    }

    override def reads(json: JsValue): JsResult[TrafficLight] = json match {
      case JsNumberToInt(0) => JsSuccess(Red)
      case JsNumberToInt(1) => JsSuccess(Amber)
      case JsNumberToInt(2) => JsSuccess(Green)
      case _ => JsError(JsonValidationError(""))

    }
  }
}

object JsNumberToInt {
  def unapply(arg: JsValue): Option[Int] = {
    arg match {
      case JsNumber(n) => Some(n.toInt)
      case _ => None
    }
  }
}
