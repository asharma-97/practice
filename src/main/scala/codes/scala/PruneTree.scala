package codes.scala

object PruneTree extends App {
  def pruneTree(root: TreeNode): TreeNode = {
    if(root == null) return null
    root.left = pruneTree(root.left)
    root.right = pruneTree(root.right)
    if(root.left == null && root.right == null && root.value == 0) return null
    root
  }
  val tn = new TreeNode(1)
  tn.left = new TreeNode(0)
  tn.left.left = new TreeNode(0)
  tn.left.right = new TreeNode(0)

  tn.right = new TreeNode(1)
  tn.right.left = new TreeNode(0)
  tn.right.right = new TreeNode(1)
  pruneTree(tn)
}
