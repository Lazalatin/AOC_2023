import java.io.File
import java.util.stream.Collector
import java.util.stream.Collectors

var result: Int = 0

File("./day2.txt").forEachLine {
    var bagContent:Map<String, Int> = mapOf(
        Pair("red", 0),
        Pair("green", 0),
        Pair("blue", 0)
    )

    it.substringAfter(':').split(';').forEach {
        val minimalMap = it.split(',').stream().map {
            Pair(it.trimStart().split(' ', limit = 2).component2(),
                it.trimStart().split(' ', limit = 2).component1().toInt())
        }.collect(Collectors.toList()).toMap()
        bagContent = (bagContent.toList() + minimalMap.toList())
            .groupBy({ it.first }, { it.second })
            .map { (key, values) -> key to values.max() }
            .toMap()
    }
    result += bagContent.values.reduce { acc, i -> acc * i }
}

println(result)
