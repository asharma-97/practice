package codes.scala

object DistributeCoins extends App {
  def distributeCoins(root: TreeNode): Int = {
    helper(root)._2
  }
  // Tuple's first value contains (extra / less) value passed to parent
  // Tuple's second value contains result (difference) so far
  def helper(node: TreeNode): (Int, Int) = {
    if(node == null) return (0, 0)
    val left = helper(node.left)
    val right = helper(node.right)
    (node.value + left._1 + right._1 - 1, Math.abs(left._1) + Math.abs(right._1) + Math.abs(left._2) + Math.abs(right._2))
  }
  val tn = new TreeNode(0)
  tn.left = new TreeNode(0)
  tn.right = new TreeNode(3)
  println(distributeCoins(tn))
}
