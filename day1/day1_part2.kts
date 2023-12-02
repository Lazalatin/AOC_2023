import java.io.File

val digitWords: List<String> = listOf("one","two","three","four","five","six","seven","eight","nine")

val digitWordsReplacements: List<Pair<String, String>> = listOf(
  Pair("one", "1"),
  Pair("two", "2"),
  Pair("three", "3"),
  Pair("four", "4"),
  Pair("five", "5"),
  Pair("six", "6"),
  Pair("seven", "7"),
  Pair("eight", "8"),
  Pair("nine", "9")
)
var result: Int = 0;

File("./day1.txt").forEachLine {
  var line = it
  val firstDigitWord = line.findAnyOf(digitWords)?.second
  val lastDigitWord = line.findLastAnyOf(digitWords)?.second

  if (firstDigitWord != null) {
    line = line.replaceFirst(
      firstDigitWord,
      digitWordsReplacements.first { pair -> pair.first == firstDigitWord }.second,
      true
    )
    if (lastDigitWord != null) {
      line = line.replace(
        lastDigitWord,
        digitWordsReplacements.first { pair -> pair.first == lastDigitWord }.second,
        true
      )
    }
  }

  line = line.filter { it.isDigit() }
  if (line.isNotEmpty()) {
    val first = line.first()
    val last = line.last()
    result += if (last.isDefined()) {
      "$first$last".toInt()
    } else {
      "$first$first".toInt()
    }
  }
}

println(result)
