package codes.scala

object MaxDepth extends App {
  def maxDepth(root: TreeNode): Int = {
    def helper(node: TreeNode, d: Int): Int = {
      if(node == null) return d
      val l = helper(node.left, d + 1)
      val r = helper(node.right, d + 1)
      if (l > r) l else r
    }
    helper(root, 0)
  }
  val tn = new TreeNode(3)
  tn.left = new TreeNode(9)
  tn.right = new TreeNode(20)
  tn.right.left = new TreeNode(15)
  tn.right.right = new TreeNode(7)
  println(maxDepth(tn))
}
