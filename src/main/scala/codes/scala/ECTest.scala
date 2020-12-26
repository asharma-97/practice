package codes.scala

import java.time._
import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}

object ECTest extends App {
  implicit val ec: ExecutionContext = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(100))
  println(s"BEFORE: ${LocalTime.now()}")
  for (i <- 1 to 100) {
    Future {
      Thread.sleep(2000)
      println(s"AFTER $i: ${LocalTime.now()}")
    }
  }
  Thread.sleep(16000)
}
