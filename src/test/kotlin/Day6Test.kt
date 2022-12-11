import org.junit.jupiter.api.Test
import utils.AoCUtils.getFilePath
import utils.AoCUtils.linesFromFileToList

private const val MARKET_SIZE = 14

class Day6Test {
    @Test
    fun `should find the first marker (4 different letters) in the message`() {
        val filePath = getFilePath("/06/input")
        val lines = linesFromFileToList(filePath)

        lines.forEach { line ->
            var count = 0
            var marker: StringBuilder = StringBuilder()

            line.toCharArray().map { character ->
                if (marker.contains(character)) {
                    marker = marker.delete(0, marker.indexOf(character) + 1)
                }
                marker.append(character)
                count++
                if (marker.length == MARKET_SIZE) {
                    println("$marker (first marker after character $count) -> $line")
                    return@forEach
                }
            }
        }
    }
}