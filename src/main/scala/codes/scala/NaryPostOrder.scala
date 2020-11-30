package codes.scala

object NaryPostOrder {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def postorder(root: Node): List[Int] = {
    if(root == null) List()
    else root.children.foldLeft[List[Int]](List())((x, y) => x ::: postorder(y)) :+ root.value
  }
}
