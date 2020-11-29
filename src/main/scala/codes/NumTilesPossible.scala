package codes

object NumTilesPossible extends App {
  def numTilePossibilities(tiles: String): Int = {
    helper(tiles.foldLeft[Array[Int]](new Array[Int](26))((x, y) => {
      x(y.toInt - 'A'.toInt) += 1
      x
    }))
  }

  def helper(arr: Array[Int]): Int = {
    var sum = 0
    for (i <- arr.indices) {
      if (arr(i) != 0) {
        sum += 1
        arr(i) -= 1
        sum += helper(arr)
        arr(i) += 1
      }
    }
    sum
  }

  println(numTilePossibilities("AAABBC"))
}
