package codes.scala

object BalanceBST extends App {

  val tn1 = new TreeNode(1)
  tn1.right = new TreeNode(2)
  tn1.right.right = new TreeNode(3)
  tn1.right.right.right = new TreeNode(4)

  getInOrder(balanceBST(tn1)).foreach(println)


  def balanceBST(root: TreeNode): TreeNode = {
    val nodeList = getInOrder(root)
    buildBstFromInorder(nodeList, 0, nodeList.length - 1)
  }

  def getInOrder(node: TreeNode): List[Int] = {
    if(node == null) return List()
    getInOrder(node.left) ::: node.value :: getInOrder(node.right)
  }

  def buildBstFromInorder(arr: List[Int], first: Int, last: Int): TreeNode = {
    if(first > last) return null
    val mid = (first + last) / 2
    val tn = new TreeNode(arr(mid))
    tn.left = buildBstFromInorder(arr, first, mid - 1)
    tn.right = buildBstFromInorder(arr, mid + 1, last)
    tn
  }
}
