import org.junit.jupiter.api.Test
import utils.AoCUtils.getFilePath
import utils.AoCUtils.linesFromFileToList

class Day2Test {
    @Test
    fun `rock paper scissor count points from strategy guide`() {
        val filePath = getFilePath("/02/input")
        val lines = linesFromFileToList(filePath)
        var score = 0

        lines.forEach { line ->
            val round = line.split(" ")
            score += countPoints(decrypt(round[0].first()), round[1].first())
        }
        println("score: $score")
    }

    private fun countPoints(opponent: Char, you: Char): Int {
        val toCompare = updateShapeByCode(opponent, you)

        return when(toCompare) {
            'X' -> evaluate(opponent, toCompare) + 1

            'Y' -> evaluate(opponent, toCompare) + 2

            'Z' -> evaluate(opponent, toCompare) + 3

            else -> throw IllegalArgumentException()
        }
    }

    private fun evaluate(opponent: Char, you: Char): Int {
        return when (you) {
            opponent -> 3
            next(opponent) -> 6
            else -> 0
        }
    }

    private fun next(c: Char): Char {
        return if ((c + 1).isLetter())
            (c + 1)
        else
            (c - 2)
    }

    private fun decrypt(value: Char): Char {
        return when (value) {
            'A' -> 'X'
            'B' -> 'Y'
            'C' -> 'Z'
            else -> throw IllegalArgumentException()
        }
    }

    private fun updateShapeByCode(shapeToUpdate: Char, code: Char): Char {
        return when (code) {
            'X' -> downgradeShape(shapeToUpdate)
            'Y' -> shapeToUpdate
            'Z' -> next(shapeToUpdate)
            else -> throw IllegalArgumentException()
        }
    }

    private fun downgradeShape(shapeToUpdate: Char): Char {
        val c = (shapeToUpdate - 1)
        return if (c.isLetter() && c == 'W')
            'Z'
        else
            c
    }
}