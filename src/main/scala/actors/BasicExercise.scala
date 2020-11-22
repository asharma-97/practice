package actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
 * Exercises
 *
 * 1. a Counter actor
 *   - Increment
 *   - Decrement
 *   - Print
 *
 * 2. a Bank account as an actor
 * receives
 *   - Deposit an amount
 *   - Withdraw an amount
 *   - Statement
 *     replies with
 *   - Success
 *   - Failure
 *
 * interact with some other kind of actor
 */

object BasicExercise extends App {

  // ------------------------------------------------------------------------------------------------
  // ------------------------------------------------------------------------------------------------

  import Counter._

  val system = ActorSystem("exeSystem")
  val counter = system.actorOf(Props[Counter], "counter")

  class Counter extends Actor {
    var counter = 0

    override def receive: Receive = {
      case Increment => counter += 1
      case Decrement => counter -= 1
      case Print => println(s"counter: $counter")
    }
  }

  object Counter {

    case object Increment

    case object Decrement

    case object Print

  }

  (1 to 5).foreach(_ => counter ! Increment)
  counter ! Print
  (1 to 2).foreach(_ => counter ! Decrement)
  counter ! Print

  val account = system.actorOf(Props[BankAccount], "bankAccount")

  import BankAccount._
  val person = system.actorOf(Props[Person], "billionaire")

  class BankAccount extends Actor {
    var amount = 0

    override def receive: Receive = {
      case Deposit(amt) =>
        if (amount < 0) sender() ! TransactionFailure("Can not deposit negative amount") else {
          amount += amt
          sender() ! TransactionSuccess(s"Deposit of amount $amt successful")
        }
      case Withdraw(amt) =>
        if (amount < amt) sender() ! TransactionFailure("Insufficient balance")
        else if (amt < 0) sender() ! TransactionFailure("Invalid amount") else {
          amount -= amt
          sender() ! TransactionSuccess(s"Withdrawal of amount $amt successful")
        }
      case Statement => sender() ! s"Total amount in account: $amount"
    }
  }

  class Person extends Actor {

    import BankAccount._
    import Person._

    override def receive: Receive = {
      case LiveTheLife(account) =>
        account ! Deposit(10000)
        account ! Withdraw(90000)
        account ! Withdraw(500)
        account ! Statement
      case message => println(message.toString)
    }
  }

  // ------------------------------------------------------------------------------------------------
  // ------------------------------------------------------------------------------------------------
  object BankAccount {

    case class Deposit(amount: Int)

    case class Withdraw(amount: Int)

    case class TransactionSuccess(message: String)

    case class TransactionFailure(reason: String)

    case object Statement

  }

  object Person {

    case class LiveTheLife(account: ActorRef)

  }

  import Person._

  person ! LiveTheLife(account)
}
