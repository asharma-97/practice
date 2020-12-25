package codes.scala

object MinCostToMoveChips extends App {
  def minCostToMoveChips(position: Array[Int]): Int = {
    if(position.length < 2) 0
    else position.map(x => if (x % 2 == 0) "E" else "O").groupBy(identity).map(x => x._2.length).min
  }
}
