package codes.scala

import scala.collection.mutable

object MaxLevelSum extends App {
  val tn = new TreeNode(-100)

  /**
   * public int maxLevelSum(TreeNode root) {
   * List<Integer> list = new ArrayList<>();
   * dfs(root, list, 0);
   * return 1 + IntStream.range(0, list.size()).reduce(0, (a, b) -> list.get(a) < list.get(b) ? b : a);
   * }
   * private void dfs(TreeNode n, List<Integer> l, int level) {
   * if (n == null) { return; }
   * if (l.size() == level) { l.add(n.val); } // never reach this level before, add first value.
   * else { l.set(level, l.get(level) + n.val); } // reached the level before, accumulate current value to old value.
   * dfs(n.left, l, level + 1);
   * dfs(n.right, l, level + 1);
   * }
   *
   */

  def maxLevelSum(root: TreeNode): Int = {
    val nodes1 = mutable.Queue[TreeNode]()
    val nodes2 = mutable.Queue[TreeNode]()
    nodes1.enqueue(root)
    var max = Integer.MIN_VALUE
    var sum = 0
    var currentLevel = 1
    var level = 1
    while (nodes1.nonEmpty || nodes2.nonEmpty) {
      if (nodes1.nonEmpty) {
        while (nodes1.nonEmpty) {
          val tn: TreeNode = nodes1.dequeue()
          sum += tn.value
          if (tn.left != null) nodes2.enqueue(tn.left)
          if (tn.right != null) nodes2.enqueue(tn.right)
        }
        if (sum > max) {
          max = sum;
          level = currentLevel
        }
        currentLevel += 1;
        sum = 0
      }
      if (nodes2.nonEmpty) {
        while (nodes2.nonEmpty) {
          val tn: TreeNode = nodes2.dequeue()
          sum += tn.value
          if (tn.left != null) nodes1.enqueue(tn.left)
          if (tn.right != null) nodes1.enqueue(tn.right)
        }
        if (sum > max) {
          max = sum;
          level = currentLevel
        }
        currentLevel += 1;
        sum = 0
      }
    }
    level
  }
  tn.left = new TreeNode(-200)
  tn.right = new TreeNode(-300)
  tn.left.left = new TreeNode(-20)
  tn.left.right = new TreeNode(-5)
  tn.right.left = new TreeNode(-10)

  println(maxLevelSum(tn))
}
