package example

import java.util.UUID

import com.trueaccord.scalapb.TypeMapper

case class EventId(id: UUID)

object EventId {
  implicit val typeMapper = TypeMapper[String, EventId]{str => apply(UUID.fromString(str))}{_.id.toString}
}

case class PosMoneyAmount(amount: Int) {
  require(amount > 0, "PosMoneyAmounts must be positive")
}

object PosMoneyAmount {
  implicit val typeMapper = TypeMapper(apply(_: Int))(_.amount)
}
