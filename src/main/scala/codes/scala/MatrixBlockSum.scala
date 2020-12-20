package codes.scala

object MatrixBlockSum extends App {
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    def sumArray(mat: Array[Array[Int]]): Unit = {
      for (i <- mat.indices) {
        var sum = 0
        for (j <- mat(0).indices) {
          sum += mat(i)(j)
          if (i == 0) mat(i)(j) = sum else mat(i)(j) = sum + mat(i - 1)(j)
        }
      }
    }

    sumArray(mat)
    val res: Array[Array[Int]] = new Array[Array[Int]](mat.length)
    for (i <- mat.indices) {
      val arr = new Array[Int](mat(0).length)
      res(i) = arr
      for (j <- mat(0).indices) {
        val starti = if (i - K < 0) 0 else i - K
        val startj = if (j - K < 0) 0 else j - K
        val endi = if (i + K > mat.length - 1) mat.length - 1 else i + K
        val endj = if (j + K > mat(0).length - 1) mat(0).length - 1 else j + K
        res(i)(j) = (starti, startj) match {
          case (0, 0) => mat(endi)(endj)
          case (0, j) => mat(endi)(endj) - mat(endi)(j - 1)
          case (i, 0) => mat(endi)(endj) - mat(i - 1)(endj)
          case (i, j) => mat(endi)(endj) - mat(endi)(j - 1) - mat(i - 1)(endj) + mat(i - 1)(j - 1)
        }
      }
    }
    res
  }

  matrixBlockSum(Array(Array(67, 64, 78), Array(99, 98, 38), Array(82, 46, 46), Array(6, 52, 55), Array(55, 99, 45)), 3)
}
