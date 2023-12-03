import java.io.File

var result: Int = 0

File("./day1.txt").forEachLine {
    val line = it.filter { it.isDigit() }

    if (line.isNotEmpty()) {
        val first = line.first()
        val last = line.last()
        result += "$first$last".toInt()
    }
}

println(result)
