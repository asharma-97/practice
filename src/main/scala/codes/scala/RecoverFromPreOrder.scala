package codes.scala

// Input: S = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]

object RecoverFromPreOrder extends App {
  def recoverFromPreorder(S: String): TreeNode = {
    val s: List[Char] = S.toList
    helper(s, 0)._1
  }

  def helper(s: List[Char], level: Int): (TreeNode, List[Char]) = {
    if (s.isEmpty) return (null, s)
    val (depth, rest) = s.span(_ == '-') match {
      case (d, r) => (d.length, r)
    }
    if (depth != level) return (null, s)
    val (num, restString) = rest.span(_ != '-') match {
      case (n, ns) =>
        (n.foldLeft("")((x, y) => x + y).toInt, ns)
    }
    val tn = new TreeNode(num)
    val c = helper(restString, level + 1)
    tn.left = c._1
    val c2 = helper(c._2, level + 1)
    tn.right = c2._1
    (tn, c2._2)
  }

  recoverFromPreorder("1-2--3--4-5--6--7")
}
