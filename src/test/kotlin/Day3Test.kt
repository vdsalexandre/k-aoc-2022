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
        }.sumOf { letter ->
            if (letter.isUpperCase())
                (letter.code - UPPER_VALUE)
            else
                (letter.code - LOWER_VALUE)
        }.also { println(it) }
    }

    @Test
    fun `rucksack reorganisation, update badge`() {
        val filePath = AoCUtils.getFilePath("/03/input")
        val lines = AoCUtils.linesFromFileToList(filePath)
        val groups = mutableListOf<Triple<String, String, String>>()

        for (i in lines.indices step 3) {
            groups.add(Triple(lines[i], lines[i+1], lines[i+2]))
        }

        groups.map { group ->
            group
                .first
                .toCharArray()
                .first { c -> group.second.contains(c) && group.third.contains(c) }
        }.sumOf { letter ->
            if (letter.isUpperCase())
                (letter.code - UPPER_VALUE)
            else
                (letter.code - LOWER_VALUE)
        }.also { println(it) }
    }
}