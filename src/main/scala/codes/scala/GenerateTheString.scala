package codes.scala

object GenerateTheString {
  def generateTheString(n: Int): String = {
    if(n%2 == 0) ("a" * (n-1)) + "b"
    else "a" * n
  }
}
