import org.junit.jupiter.api.Test
import utils.AoCUtils

private const val UPPER_VALUE = 38
private const val LOWER_VALUE = 96

class Day3Test {

    @Test
    fun `rucksack reorganization, add priority values`() {
        val filePath = AoCUtils.getFilePath("/03/input")
        val lines = AoCUtils.linesFromFileToList(filePath)

        lines.map { line ->
            Pair(line.substring(0, line.length / 2), line.substring(line.length / 2))
        }.map { twoCompartment ->
            twoCompartment
                .first
                .toCharArray()
                .first { c -> twoCompartment.second.contains(c) }
        }.sumOf {letter ->
            if (letter.isUpperCase())
                (letter.code - UPPER_VALUE)
            else
                (letter.code - LOWER_VALUE)
        }.also { println(it) }

    }
}