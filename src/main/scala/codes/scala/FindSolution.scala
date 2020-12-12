package codes.scala

object FindSolution extends App {

  class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    def f(x: Int, y: Int): Int = {
      x + y
    }
  }

  def findSolution(customfunction: CustomFunction, z: Int): List[List[Int]] = {
    def fun(x: Int, y: Int): List[List[Int]] = {
      if (x > 1000 || y <= 0) return List()
      val v = customfunction.f(x, y)
      if (v < z) fun(x + 1, y)
      else if (v > z) fun(x, y - 1)
      else List(List(x, y)) ::: fun(x + 1, y - 1)
    }

    fun(1, 1000)
  }
  findSolution(new CustomFunction(), 5).foreach(_.foreach(print))
}
