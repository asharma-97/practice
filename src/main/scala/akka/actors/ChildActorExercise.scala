package akka.actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ChildActorExercise extends App {
  // Distributed word counting

  object WordCounterMaster {
    case class Initialise(nChildren: Int)
    case class WordCountTask(text: String)
    case class WordCountReply(count: Int)
  }
  class WordCounterMaster extends Actor {
    import WordCounterMaster._
    override def receive: Receive = {
      case Initialise(n) =>
        val l = (1 to n).map(x => context.actorOf(Props[WordCounterWorker], s"child-${x}"))
        context.become(ready(l.toList, currentWorker = 0))
    }
    def ready(workers: List[ActorRef], currentWorker: Int): Receive = {
      case WordCountTask(text) =>
        workers(currentWorker) ! WordCountTask(text)
        context.become(ready(workers, (currentWorker + 1) % workers.length))
      case WordCountReply(num) => println(s"${self.path} :: count is = $num")
    }
  }

  class WordCounterWorker extends Actor {
    import WordCounterMaster._
    override def receive: Receive = {
      case WordCountTask(message: String) =>
        println(s"${self.path} :: Received this task: $message")
        sender() ! WordCountReply(message.split(" ").length)
    }
  }

  val system = ActorSystem("system")
  val master = system.actorOf(Props[WordCounterMaster], "master")
  import WordCounterMaster._
  master ! Initialise(2)
  master ! WordCountTask("Hey, this is your first task")
  master ! WordCountTask("Hey, how are you?")
  master ! WordCountTask("Which one is your favourite child?")
  master ! WordCountTask("Alright, I'll terminate you now :)")
}
