package codes

object NaryPreOrder extends App {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def preorder(root: Node): List[Int] = {
    if(root == null) return List()
    root.value :: root.children.foldLeft[List[Int]](List())((x, y) => x ::: preorder(y))
  }

  val tn = new Node(1)
  tn.children = List(new Node(3), new Node(2), new Node(4))
  tn.children.head.children = List(new Node(5), new Node(6))
  preorder(tn).foreach(println)

}