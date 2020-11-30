package codes.scala

object FindElements extends App {
  val _root: TreeNode = new TreeNode(-1)
  _root.right = new TreeNode(-1)

  def find(target: Int): Boolean = {
    helper(_root, target, 0)
  }
  def helper(node: TreeNode, target: Int, current: Int): Boolean = {
    if(node == null) return false
    if(target == current) return true
    helper(node.left, target, current * 2 + 1) || helper(node.right, target, current * 2 + 2)
  }

  println(find(1))
}
