package codes.scala

object CountSquares extends App {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    for (i <- 1 until matrix.length) {
      for (j <- 1 until matrix(0).length) {
        if (matrix(i)(j) == 1) {
          if (matrix(i - 1)(j) == matrix(i)(j - 1) && matrix(i - 1)(j) == matrix(i - 1)(j - 1))
            matrix(i)(j) = matrix(i - 1)(j) + 1
          else
            matrix(i)(j) = Math.min(matrix(i - 1)(j), Math.min(matrix(i - 1)(j - 1), matrix(i)(j - 1))) + 1
        }
      }
    }
    var result = 0
    for (i <- matrix.indices) {
      for (j <- matrix(0).indices) {
        result += matrix(i)(j)
      }
    }
    result
  }

  println(countSquares(Array(Array(1, 0, 1), Array(1, 1, 0), Array(1, 1, 0))))
}
