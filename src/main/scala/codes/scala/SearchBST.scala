package codes.scala

object SearchBST extends App {
def searchBST(root: TreeNode, `val`: Int): TreeNode = {
  if(root == null) return null
  if(root.value == `val`) return root
  val r1 = searchBST(root.left, `val`)
  val r2 = searchBST(root.right, `val`)
  (r1, r2) match {
    case (r1, null) => r1
    case (null, r2) => r2
    case (null, null) => null
  }
}

  val tn = new TreeNode(4)
  tn.left = new TreeNode(2)
  tn.left.left = new TreeNode(1)
  tn.left.right = new TreeNode(3)
  tn.right = new TreeNode(7)
  searchBST(tn, 2)
}
