package akka.actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.actors.ChildActors.Parent.{CreateChild, TellChild}

object ChildActors extends App {

  object Parent {
    case class CreateChild(name: String)
    case class TellChild(message: String)
  }
  class Parent extends Actor {
    import Parent._

    override def receive: Receive = {
      case CreateChild(name) =>
        println(s"${self.path} :: creating child")
        val child = context.actorOf(Props[Child], name)
        context.become(childCreated(child))
    }
    def childCreated(child: ActorRef): Receive = {
      case TellChild(message) => child forward message
    }
  }

  class Child extends Actor {
    override def receive: Receive = {
      case message => println(s"${self.path} :: I got: $message")
    }
  }

  val system = ActorSystem("system")
  val parent = system.actorOf(Props[Parent], "parent")
  parent ! CreateChild("childA")
  parent ! TellChild("Hello child, first message")

  // Actor hierarchies
  // Guardians are top level actor:
  //    1. /       = Root level. (System and user are children of root)
  //    2. /system = System guardian
  //    3. /user   = User level. (Everything created by system.actorOf is child of this)

  // parent -> child1 -> ...
  //        -> child2 -> ...

  // Actor selection (Find actor by it's path)
  val childSelection = system.actorSelection("/user/parent/childA")
  childSelection ! "Hey"

  /**
   * NEVER PASS MUTABLE ACTOR STATE, OR 'THIS' REFERENCE, TO CHILD ACTORS.
   * */

  object NaiveBankAccount {
    case class Deposit(amount: Int)
    case class Withdraw(amount: Int)
    case object InitialiseAccount
  }
  class NaiveBankAccount extends Actor {
    import NaiveBankAccount._
    import CreditCard._

    var amount = 0
    override def receive: Receive = {
      case InitialiseAccount =>
        val creditCardRef = context.actorOf(Props[CreditCard])
        creditCardRef ! AttachToAccount(this) // !!
      case Deposit(funds) => deposit(funds)
      case Withdraw(funds) =>   withdraw(funds)
    }
    def deposit(funds: Int): Unit = amount += funds
    def withdraw(funds:Int): Unit = amount -= funds
  }

  object CreditCard {
    // Here is the problem, we are passing instance of actual class instead of
    // sending ActorRef
    case class AttachToAccount(bankAccount: NaiveBankAccount)
    case object CheckStatus
  }
  class CreditCard extends Actor {
    import CreditCard._
    override def receive: Receive = {
      case AttachToAccount(account) => context.become(attachedToAccount(account))
    }
    def attachedToAccount(account: NaiveBankAccount): Receive = {
      case CheckStatus =>
        println(s"${self.path} :: Your message has been processed")
        /**
         * Here is problem [We have passed down 'THIS' reference and now child can mutate states]
         * */
        account.withdraw(100) // Closing over mutable state or this reference
    }
  }
}
