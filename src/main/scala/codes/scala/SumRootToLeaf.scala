package codes.scala

object SumRootToLeaf extends App {
  def sumRootToLeaf(root: TreeNode): Int = {
    helper(root, "")
  }
  def helper(node: TreeNode, number: String): Int = {
    if(node == null) return 0
    val updatedNumber = number + node.value
    if(node.left == null && node.right == null) return Integer.parseInt(updatedNumber, 2)
    helper(node.left, updatedNumber) + helper(node.right, updatedNumber)
  }
  val tn = new TreeNode(1)
  tn.left = new TreeNode(0)
  tn.left.left = new TreeNode(0)
  tn.left.right = new TreeNode(1)

  tn.right = new TreeNode(1)
  tn.right.left = new TreeNode(0)
  tn.right.right = new TreeNode(1)
  println(sumRootToLeaf(tn))
}
