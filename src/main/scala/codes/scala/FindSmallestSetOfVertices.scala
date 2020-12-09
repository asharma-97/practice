package codes.scala

object FindSmallestSetOfVertices {
  def findSmallestSetOfVertices(n: Int, edges: List[List[Int]]): List[Int] = {
    (0 until n).toSet.diff(edges.map(_.last).groupBy(identity).keys.toSet).toList
  }
}
