package cats

import cats.implicits._

object SemigroupExercise extends App {
  println(Semigroup[Int].combine(1, 2))
  println(Semigroup[List[Int]].combine(List(1, 2, 3), List(4, 5, 6)))
  println(Semigroup[Option[Int]].combine(Option(1), Option(2)))
  println(Semigroup[Option[Int]].combine(Option(1), None))

  val one: Option[Int] = Option(1)
  val two: Option[Int] = Option(2)
  val n: Option[Int] = None

  println(one |+| two)
  println(n |+| two)
  println(n |+| n)
  println(two |+| n)
}
