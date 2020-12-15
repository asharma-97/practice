package codes.scala

import scala.collection.mutable

object MinAddToMakeValid extends App {
  def minAddToMakeValid(S: String): Int = {
    val stack: mutable.Stack[Int] = new mutable.Stack[Int]()
    var ans = 0
    for (i <- S) {
      if (i == '(') stack.push(i)
      else {
        if (stack.isEmpty) ans += 1
        else stack.pop()
      }
    }
    while (stack.nonEmpty) {
      stack.pop()
      ans += 1
    }
    ans
  }

  println(minAddToMakeValid("()))(("))
}
