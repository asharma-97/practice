package codes.scala

object RemoveLeafNodes extends App {
  def removeLeafNodes(root: TreeNode, target: Int): TreeNode = {
    if(root == null) return null
    root.left = removeLeafNodes(root.left,target)
    root.right = removeLeafNodes(root.right, target)
    if(root.left == null && root.right == null) {
      if(root.value == target) {
        return null
      }
    }
    root
  }
  val tn = new TreeNode(1)
  tn.left = new TreeNode(2)
  tn.left.left = new TreeNode(2)
  tn.right = new TreeNode(3)
  tn.right.left = new TreeNode(2)
  tn.right.right = new TreeNode(4)
  removeLeafNodes(tn, 2)
}
