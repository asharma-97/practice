package codes

object MergeTrees extends App {
  val tn1 = new TreeNode(1)
  val tn2 = new TreeNode(2)
  tn1.left = new TreeNode(3)
  tn1.left.left = new TreeNode(5)
  tn1.right = new TreeNode(2)

  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    if (t1 == null && t2 == null) return null
    val node: TreeNode = new TreeNode()
    (t1, t2) match {
      case (null, t2) =>
        node.value = t2.value
        node.left = mergeTrees(t1, t2.left)
        node.right = mergeTrees(t1, t2.right)
      case (t1, null) =>
        node.value = t1.value
        node.left = mergeTrees(t1.left, t2)
        node.right = mergeTrees(t1.right, t2)
      case (t1, t2) =>
        node.value = t1.value + t2.value
        node.left = mergeTrees(t1.left, t2.left)
        node.right = mergeTrees(t1.right, t2.right)
    }

    node
  }
  tn2.left = new TreeNode(1)
  tn2.left.right = new TreeNode(4)
  tn2.right = new TreeNode(3)
  tn2.right.right = new TreeNode(7)
  mergeTrees(tn1, tn2)
}
