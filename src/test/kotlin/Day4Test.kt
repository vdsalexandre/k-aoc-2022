import model.Range
import org.junit.jupiter.api.Test
import utils.AoCUtils

class Day4Test {

    @Test
    fun `camp cleanup, find overlaps`() {
        val filePath = AoCUtils.getFilePath("/04/input")
        val lines = AoCUtils.linesFromFileToList(filePath)
        var count = 0

        val sections = lines.map { line ->
            line.split(",")
                .map {
                    val range = it.split("-")
                    Range(range[0].toInt(), range[1].toInt())
                }
        }

        sections.forEach { section ->
            if (section[0].fullyContains(section[1]))
                count++
            else {
                if (section[1].fullyContains(section[0]))
                    count++
            }
        }

        println("count: $count")
    }
}