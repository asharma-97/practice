package codes.scala

object GoodNodes extends App {
  val tn = new TreeNode(3)

  def goodNodes(root: TreeNode): Int = {
    helper(root, Integer.MIN_VALUE)
  }

  def helper(node: TreeNode, max: Int): Int = {
    if (node == null) return 0
    val current = if (node.value >= max) 1 else 0
    current + helper(node.left, Math.max(max, node.value)) + helper(node.right, Math.max(max, node.value))
  }
  tn.left = new TreeNode(1)
  tn.right = new TreeNode(4)
  tn.left.left = new TreeNode(3)
  tn.right.left = new TreeNode(1)
  tn.right.right = new TreeNode(5)
  println(goodNodes(tn))
}
