package akka.actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ActorCapabilities extends App {

  val system = ActorSystem("actorCapabilitiesDemo")
  val simpleActor = system.actorOf(Props[SimpleActor], "simpleActor")
  val alice = system.actorOf(Props[SimpleActor], "alice")
  val bob = system.actorOf(Props[SimpleActor], "bob")

  case class SendMessageToSelf(message: String)

  simpleActor ! "Hello, actor"
  simpleActor ! SpecialMessage("Special message")
  simpleActor ! SendMessageToSelf("I'll send it to myself")

  case class SpecialMessage(message: String)

  class SimpleActor extends Actor {
    context.self.path

    override def receive: Receive = {
      case "hi" => context.sender() ! "Hello there"
      case msg: String => println(s"[${context.self.path}] 1. message: $msg")
      case SpecialMessage(msg) => println(s"[${context.self.path}] 2. message: $msg")
      case SendMessageToSelf(msg) => self ! msg
      case SayHiTo(ref) => ref ! "hi"
      case WirelessPhoneMessage(msg, ref) => ref forward (msg + "s")
    }
  }

  case class SayHiTo(ref: ActorRef)

  alice ! SayHiTo(bob)

  // Forwarding messages
  case class WirelessPhoneMessage(message: String, ref: ActorRef)

  alice ! WirelessPhoneMessage("hi", bob)
}
