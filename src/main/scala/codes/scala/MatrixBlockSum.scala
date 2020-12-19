package codes.scala

object MatrixBlockSum extends App {
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    def sumArray(mat: Array[Array[Int]]): Unit = {
      for(i <- mat.indices) {
        var sum = 0
        for(j <- mat(0).indices) {
          sum += mat(i)(j)
          if(i==0) mat(i)(j) = sum else mat(i)(j) = sum + mat(i-1)(j)
        }
      }
    }
    sumArray(mat)
    val res: Array[Array[Int]] = new Array[Array[Int]](mat.length)
    ???
  }
  val c =matrixBlockSum(List(List(1,2,3).toArray, List(4,5,6).toArray, List(7,8,9).toArray).toArray, 1)
  val x = 1
}
