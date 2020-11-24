package akka.actors

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.event.{Logging, LoggingAdapter}

object ActorLogging extends App {
  /**
   * 1. Explicit logging
   * */
  class SimpleActorWithExplicitLogger extends Actor {
    // 1 - debug
    // 2 - info
    // 3 - warn
    // 4 - error
    val logger: LoggingAdapter = Logging(context.system, this)

    override def receive: Receive = {
      case message =>
        logger.info(message.toString)
    }
  }

  /**
   * 2. Actor logging
   * */
  class SimpleActorWithLogging extends Actor with ActorLogging {
    override def receive: Receive = {
      case (a, b) => log.info("Two things: {} and {}", a, b)
      case message =>
        log.info(message.toString)
    }
  }

  val system = ActorSystem("system")
  val simpleActorWithExplicitLogger = system.actorOf(Props[SimpleActorWithExplicitLogger])
  val simpleActorWithLogging = system.actorOf(Props[SimpleActorWithLogging])
  simpleActorWithExplicitLogger ! "[Explicit logging] Hey, log this message"
  simpleActorWithLogging ! "[Actor logging] Hey, log this message"
  simpleActorWithLogging ! (1, 2)
}
