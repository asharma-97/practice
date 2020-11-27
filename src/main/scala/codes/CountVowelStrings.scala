package codes

object CountVowelStrings extends App {
  def countVowelStrings(n: Int): Int = {
    (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24
  }
}
