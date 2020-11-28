package codes

import scala.collection.mutable.Stack

class CustomStack(_maxSize: Int) {

  val arr = new Array[Int](_maxSize)
  val stack = Stack[Int]()

  def push(x: Int): Unit = {
    if (stack.size < _maxSize)
      stack.push(x)
  }

  def pop(): Int = {
    val stackSize = stack.size - 1
    if(stackSize < 0) return -1
    if (stackSize > 0) arr(stackSize - 1) += arr(stackSize)
    val retValue = stack.pop() + arr(stackSize)
    arr(stackSize) = 0
    retValue
  }

  def increment(k: Int, `val`: Int): Unit = {
    val x = Math.min(stack.size, k) - 1
    if (x >= 0)
      arr(x) += `val`
  }

}

object CustomStack extends App {
  var obj = new CustomStack(5)

}