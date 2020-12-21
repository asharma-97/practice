package codes.scala

object HammingDistance extends App {
  def hammingDistance(x: Int, y: Int): Int = {
    (x ^ y).toBinaryString.count(_ == '1')
  }
}
