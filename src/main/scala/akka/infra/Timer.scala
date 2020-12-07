package akka.infra

import akka.actor.{Actor, ActorLogging, ActorSystem, Cancellable, PoisonPill, Props}

import scala.concurrent.duration._
import scala.language.postfixOps

object Timer extends App {
  /**
   * Exercise: Implement a self closing actor
   *
   * - If actor receive a message (anything), you have 1 second to send it another message
   * - If the time window expires, the actor will stop itself
   * - If you send another message, the time window resets
   * */
  val system = ActorSystem("system")

  import system.dispatcher

  class SelfClosingActor extends Actor with ActorLogging {
    def createTimeoutWindow(): Cancellable = system.scheduler.scheduleOnce(1 second) {
      self ! PoisonPill
    }

    override def receive: Receive = closableActor(createTimeoutWindow())

    def closableActor(c: Cancellable): Receive = {
      case message =>
        log.info(message.toString)
        c.cancel()
        context.become(closableActor(system.scheduler.scheduleOnce(1 second) {
          self ! PoisonPill
        }))
    }
  }

  val actor = system.actorOf(Props[SelfClosingActor])
  val routine = system.scheduler.scheduleOnce(0.5 second) {
    actor ! "PING!"
  }

  system.scheduler.scheduleOnce(4 second) {
    actor ! "Are you there?"
  }
}
