package codes.scala

object PseudoPalindromicPaths extends App {
  def pseudoPalindromicPaths (root: TreeNode): Int = {
    if(root == null) 0
    else helper(root, Map())
  }
  def helper(node: TreeNode, map: Map[Int, Int]): Int = {
    if(node == null) return 0
    val updatedMap = map + (node.value -> (map.getOrElse(node.value, 0) + 1))
    val current = if(node.left == null && node.right == null && checkIfPalindrome(updatedMap)) return 1 else 0
    current + helper(node.left, updatedMap) + helper(node.right, updatedMap)
  }
  def checkIfPalindrome(value: Map[Int, Int]): Boolean = {
    val sizeOfOdd = (for (i <- value.values if i % 2 != 0) yield 1).size
    val totalElems: Int = value.values.sum
    (totalElems % 2 == 0 && sizeOfOdd == 0) || (totalElems % 2 == 1 && sizeOfOdd == 1)
  }
  val tn = new TreeNode(2)
  tn.left = new TreeNode(3)
  tn.right = new TreeNode(1)
  tn.left.left = new TreeNode(3)
  tn.left.right = new TreeNode(1)
  tn.right.right = new TreeNode(1)
  println(pseudoPalindromicPaths(tn))
}
