package codes.scala

object LcaDeepestLeaves extends App {
  def lcaDeepestLeaves(root: TreeNode): TreeNode = {
    def helper(node: TreeNode, depth: Int): (TreeNode, Int) = {
      if (node == null) return (null, depth)
      val l = helper(node.left, depth + 1)
      val r = helper(node.right, depth + 1)
      if (l._2 == r._2) (node, l._2)
      else {if (l._2 > r._2) l else r}
    }

    helper(root, 0)._1
  }
}
