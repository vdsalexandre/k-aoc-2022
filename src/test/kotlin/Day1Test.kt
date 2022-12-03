import org.junit.jupiter.api.Test
import utils.AoCUtils.getFilePath
import utils.AoCUtils.linesFromFileToList

class Day1Test {

    @Test
    fun `count calories for each elves`() {
        val filePath = getFilePath("/01/input")
        val lines = linesFromFileToList(filePath)

        var calories = 0
        val wallOfCalories = mutableListOf<Int>()
        val maxElements = mutableListOf<Int>()

        lines.forEach { line ->
            try {
                calories += line.toInt()
            } catch (e: Exception) {
                wallOfCalories.add(calories)
                calories = 0
            }
        }

        for (i in 0..2) {
            val max = wallOfCalories.max()
            wallOfCalories.remove(max)
            maxElements.add(max)
        }

        println(maxElements.sum())
    }
}