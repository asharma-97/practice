package akka.testing

import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.wordspec.AnyWordSpecLike

import scala.concurrent.duration._
import scala.util.Random

class BasicSpec extends TestKit(ActorSystem("system"))
  with ImplicitSender // testActor as implicit self
  with AnyWordSpecLike
  with BeforeAndAfterAll {

  // Setup
  override def afterAll(): Unit = {
    TestKit.shutdownActorSystem(system)
  }

  import BasicSpec._

  "A simple actor" should {
    "send back the same message" in {
      val simpleActor = system.actorOf(Props[SimpleActor])
      val message = "Hi"
      simpleActor ! message
      expectMsg(message) // akka.test.single-expect-default
    }
  }

  "A black hole actor" should {
    "not send back the same message" in {
      val blackHole = system.actorOf(Props[BlackHole])
      val message = "Hi"
      blackHole ! message
      expectNoMessage(1.second)
    }
  }

  "A lab test actor" should {
    val labTestActor =system.actorOf(Props[LabTestActor])
    "turn a string into uppercase" in {
      val msg = "turn this to upper"
      labTestActor ! msg
      val reply = expectMsgType[String]
      assert(reply == msg.toUpperCase)
    }

    "reply to a greeting" in {
      labTestActor ! "greeting"
      expectMsgAnyOf("hi", "hello")
    }

    "reply with favpurite tech" in {
      labTestActor ! "favouriteTech"
      expectMsgAllOf("scala", "akka")
    }

    "reply with cool tech in different way" in {
      labTestActor ! "favouriteTech"
      val messages = receiveN(2) // Seq[Any]
      // Complicated assertions
    }

    "reply with cool tech in different way-2" in {
      labTestActor ! "favouriteTech"
      expectMsgPF() {
        case "scala" =>
        case "akka" =>
      }
    }
  }

}

object BasicSpec {

  class SimpleActor extends Actor {
    override def receive: Receive = {
      case message => sender() ! message
    }
  }

  class BlackHole extends Actor {
    override def receive: Receive = Actor.emptyBehavior
  }

  class LabTestActor extends Actor {
    val random = new Random()
    override def receive: Receive = {
      case "greeting" => sender() ! {
        if (random.nextBoolean) "hi" else "hello"
      }
      case "favouriteTech" =>
        sender() ! "scala"
        sender() ! "akka"
      case message: String => sender() ! message.toUpperCase
    }
  }

}
