package akka.actors

import akka.actor.{Actor, ActorSystem, Props}

object ChangingBehaviourExercise extends App {
  /**
   * 1. Recreate counter actor with context.become and no mutable state
   * 2. Simplified voting system
   * */

  /**
   * Solution - 1 [Counter]
   * */
  object Counter {
    case object Increment
    case object Decrement
    case object Print
  }

  class Counter extends Actor {
    import Counter._

    override def receive: Receive = receiveMod(0)

    def receiveMod(count: Int): Receive = {
      case Increment => context.become(receiveMod(count + 1))
      case Decrement => context.become(receiveMod(count - 1))
      case Print => println(count)
    }
  }
  val sys = ActorSystem("system")
  import Counter._

  val counter = sys.actorOf(Props[Counter], "myCounter")

  (1 to 5).foreach(_ => counter ! Increment)
  (1 to 4).foreach(_ => counter ! Decrement)
  counter ! Print

  // -----------------------------------------------------------------------------------------------------------------
  // -----------------------------------------------------------------------------------------------------------------


  /**
   * Exercise 2 - a simplified voting system
   */

  case class Vote(candidate: String)
  case object VoteStatus
  case class VoteStatusReply(c: Option[String])

  class Citizen extends Actor {
    override def receive: Receive = {
      case Vote(c) => context.become(voted(c))
      case VoteStatus => VoteStatusReply(None)
    }

    def voted(candidate: String): Receive = {
      case VoteStatus => VoteStatusReply(Some(candidate))
    }
  }
}
