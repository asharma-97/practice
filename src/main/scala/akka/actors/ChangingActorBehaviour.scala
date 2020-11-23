package akka.actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.actors.ChangingActorBehaviour.Mom.MomStart

object ChangingActorBehaviour extends App {
  val system = ActorSystem("system")

  object FuzzyKid {
    case object KidAccept
    case object KidReject
    val HAPPY = "happy"
    val SAD = "sad"
  }

  // A mutable state to store internal state of Akka actor
  class FuzzyKid extends Actor {
    import FuzzyKid._
    import Mom._

    var state: String = HAPPY
    override def receive: Receive = {
      case Food(VEGETABLES) => state = SAD
      case Food(CHOCOLATE) => state = HAPPY
      case Ask(_) =>
        if(state == HAPPY) sender() ! KidAccept
        else sender() ! KidReject
    }
  }

  // Stateless Actor without any mutable variable
  class StatelessFuzzyKid extends Actor {
    import FuzzyKid._
    import Mom._

    override def receive: Receive = happyReceive
    def happyReceive: Receive = {
      case Food(VEGETABLES) => context.become(sadReceive)
      case Food(CHOCOLATE) =>
      case Ask(_) => sender() ! KidAccept
    }
    def sadReceive: Receive = {
      case Food(VEGETABLES) =>
      case Food(CHOCOLATE) => context.become(happyReceive)
      case Ask(_) => sender() ! KidReject
    }
  }

  object Mom {
    case class MomStart(kidRef: ActorRef)
    case class Food(food: String)
    case class Ask(message: String)
    val VEGETABLES = "veggies"
    val CHOCOLATE = "chocolate"
  }

  class Mom extends Actor {
    import Mom._
    import FuzzyKid._

    override def receive: Receive = {
      case MomStart(kidRef) =>
        kidRef ! Food(VEGETABLES)
        kidRef ! Ask("Do you want to play?")
      case KidAccept =>
        println(":)")
      case KidReject =>
        println(":(")
    }
  }

  val fuzzyKid = system.actorOf(Props[FuzzyKid])
  val statelessFuzzyKid = system.actorOf(Props[StatelessFuzzyKid])
  val mom = system.actorOf(Props[Mom])
//  mom ! MomStart(fuzzyKid)
  mom ! MomStart(statelessFuzzyKid)
}
