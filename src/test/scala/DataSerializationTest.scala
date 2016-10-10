import java.util.UUID

import example.Event.{Deposit, Event}
import example.{EventId, PosMoneyAmount}
import org.scalatest.{FlatSpec, MustMatchers}

class DataSerializationTest extends FlatSpec with MustMatchers {

  behavior of "Custom Type serialization"

  it must "serialize and deserialize Event" in {
    val originalEvent = Event(EventId(UUID.randomUUID()))
    val deserializedEvent = Event.parseFrom(originalEvent.toByteArray)

    deserializedEvent mustBe originalEvent
  }

  it must "serialize and deserialize Deposit" in {
    val originalDeposit = Deposit(PosMoneyAmount(10))
    val deserializedDeposit = Deposit.parseFrom(originalDeposit.toByteArray)

    deserializedDeposit mustBe originalDeposit
  }
}
