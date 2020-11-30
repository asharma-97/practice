package codes.scala

object DestCity extends App {
  println(destCity(List(List("London","New York"))))
  def destCity(paths: List[List[String]]): String = {
    paths.flatMap(x => if(paths.forall(y => y.head != x(1))) Some(x(1)) else None).head
  }
}
