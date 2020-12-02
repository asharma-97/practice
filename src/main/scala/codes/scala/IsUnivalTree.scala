package codes.scala

object IsUnivalTree extends App {
  def isUnivalTree(root: TreeNode): Boolean = {
    helper(root, Set())
  }
  def helper(node: TreeNode, set: Set[Int]): Boolean = {
    if(node == null) return true
    val newSet = set + node.value
    newSet.size <= 1 && helper(node.left, newSet) && helper(node.right, newSet)
  }
  val tn = new TreeNode(2)
  tn.left = new TreeNode(2)
  tn.right = new TreeNode(2)
  tn.left.left = new TreeNode(5)
  tn.left.right = new TreeNode(2)
  isUnivalTree(tn)
}
