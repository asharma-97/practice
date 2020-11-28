package codes

import scala.collection.mutable.ListBuffer

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object AllPossibleFBT extends App {

  println(allPossibleFBT(7).length)

  /**
   * We can maintain a cache which can return head node for number N, to reduce repetitive problems
   * */
  def allPossibleFBT(N: Int): List[TreeNode] = {
    val list: ListBuffer[TreeNode] = new ListBuffer[TreeNode]()
    if (N % 2 == 0) list.toList
    else if (N == 1) (list += new TreeNode()).toList
    else {
      for (i <- 1 until N by 2) {
        val left = allPossibleFBT(i)
        val right = allPossibleFBT(N - i - 1)
        for {
          tnl <- left
          tnr <- right
        } yield {
          val node = new TreeNode()
          node.left = tnl
          node.right = tnr
          list += node
        }
      }
      list.toList
    }
  }
}