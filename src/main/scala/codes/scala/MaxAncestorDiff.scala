package codes.scala

object MaxAncestorDiff extends App {
  def maxAncestorDiff(root: TreeNode): Int = {
    if(root == null) 0
    else helper(root, root.value, root.value)
  }
  def helper(node: TreeNode, max: Int, min: Int): Int = {
    if(node == null) return 0
    val leftValue = helper(node.left, Math.max(max, node.value), Math.min(min, node.value))
    val rightValue = helper(node.right, Math.max(max, node.value), Math.min(min, node.value))
    Math.max(Math.max(Math.max(Math.abs(node.value - max), Math.abs(node.value - min)), leftValue), rightValue)
  }
  val tn = new TreeNode(8)
  tn.left = new TreeNode(3)
  tn.right = new TreeNode(10)
  tn.left.left = new TreeNode(1)
  tn.left.right = new TreeNode(6)
  tn.left.right.left = new TreeNode(4)
  tn.left.right.right = new TreeNode(7)
  tn.right.right = new TreeNode(14)
  tn.right.right.left = new TreeNode(13)
  println(maxAncestorDiff(tn))
}
