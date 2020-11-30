package codes.scala

object IncreasingBST extends App {
  val tn = new TreeNode(5)

  def increasingBST(root: TreeNode): TreeNode = {
    helper(root, null)
  }

  def helper(node: TreeNode, next: TreeNode): TreeNode = {
    if (node == null) return next
    val res: TreeNode = helper(node.left, node)
    node.left = null
    node.right = helper(node.right, next)
    res
  }


  tn.left = new TreeNode(3)
  tn.left.left = new TreeNode(2)
  tn.left.left.left = new TreeNode(1)
  tn.left.right = new TreeNode(4)

  tn.right = new TreeNode(6)
  tn.right.right = new TreeNode(8)
  tn.right.right.left = new TreeNode(7)
  tn.right.right.right = new TreeNode(9)
  increasingBST(tn)
}
