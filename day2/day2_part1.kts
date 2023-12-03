import java.io.File
import java.util.stream.Collector
import java.util.stream.Collectors

var result: Int = 0

val bagContent:Map<String, Int> = mapOf(
    Pair("red", 12),
    Pair("green", 13),
    Pair("blue", 14)
)

File("./day2.txt").forEachLine {
    val gamenumber = it.substring(0..7).filter { it.isDigit() }.toInt()
    var isValidGame = true

    it.substringAfter(':').split(';').forEach {
        it.split(',').stream().map {
            Pair(it.trimStart().split(' ', limit = 2).component2(),
                it.trimStart().split(' ', limit = 2).component1().toInt())
        }.collect(Collectors.toList()).toMap().forEach {
            if (bagContent.getValue(it.key) < it.value) isValidGame = false
        }
    }
    if (isValidGame) result += gamenumber
}

println(result)
