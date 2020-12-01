package codes.scala

object MaxDepth extends App {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def maxDepth(root: Node): Int = {
    if (root == null) 0
    else helper(root, 1)
  }

  def helper(node: Node, depth: Int): Int = {
    if (node == null) return depth
    if (node.children.isEmpty) depth
    else node.children.map(n => helper(n, depth + 1)).max
  }

  val n = new Node(1)
  n.children = List(new Node(3), new Node(2), new Node(4))
  n.children.head.children = List(new Node(5), new Node(6))
  println(maxDepth(n))
}
