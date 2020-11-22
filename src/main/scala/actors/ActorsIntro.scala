package actors

import akka.actor.{Actor, ActorSystem, Props}

object ActorsIntro extends App {
  // create actor system
  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)
  // Instantiate actor
  val wordCounterActor = actorSystem.actorOf(Props[WordCounterActor], "wordCounter")
  val bob = actorSystem.actorOf(Person("Bob"))

  // Communicate
  wordCounterActor ! "My first message"

  // create actor
  class WordCounterActor extends Actor {
    var totalWords = 0

    override def receive: Receive = {
      case message: String =>
        totalWords += message.split(" ").length
        println(s"[word counter] totalWords = $totalWords")
      case msg => println(s"[word counter] ${msg.toString} ???")
    }
  }

  // -------------------------------------------------
  // -------------------------------------------------

  // Create actor with constructor arguments
  class Person(name: String) extends Actor {
    override def receive: Receive = {
      case "hi" => println(s"Hi, my name is $name")
      case _ =>
    }
  }

  object Person {
    def apply(name: String): Props = Props(new Person(name))
  }

  bob ! "hi"


}
