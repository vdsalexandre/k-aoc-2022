import model.Cargo
import model.Crate
import model.Instruction
import org.junit.jupiter.api.Test
import utils.AoCUtils.getFilePath
import utils.AoCUtils.linesFromFileToList

class Day5Test {
    @Test
    fun `follow instructions to put crates into stacks`() {
        val filePath = getFilePath("/05/input")
        val lines = linesFromFileToList(filePath)
        val cargo = Cargo()

        initializeCargo(lines, cargo)
        val instructions = extractInstructions(lines)

        instructions.forEach { instruction ->
            for (i in 1..instruction.move) {

                if (instruction.move == 1) {
                    val crate = cargo.stacks[instruction.from]!!.pop()
                    cargo.stacks[instruction.to]!!.push(crate)
                } else {
                    val crate = cargo.stacks[instruction.from]!!.removeAt(instruction.move - i)
                    cargo.stacks[instruction.to]!!.push(crate)
                }
            }
        }

        cargo.stacks.filter { !it.value.isEmpty() }.forEach { stack ->
            println("Last crate of stack [ ${stack.key} ] : ${stack.value.last()}")
        }
    }

    private fun addCrateToStack(cargo: Cargo, crate: Crate, count: Int) {
        when (count) {
            1 -> cargo.stacks[1]!!.add(crate)
            5 -> cargo.stacks[2]!!.add(crate)
            9 -> cargo.stacks[3]!!.add(crate)
            13 -> cargo.stacks[4]!!.add(crate)
            17 -> cargo.stacks[5]!!.add(crate)
            21 -> cargo.stacks[6]!!.add(crate)
            25 -> cargo.stacks[7]!!.add(crate)
            29 -> cargo.stacks[8]!!.add(crate)
            33 -> cargo.stacks[9]!!.add(crate)
            else -> throw IllegalArgumentException("count: $count")
        }
    }

    private fun initializeCargo(lines: List<String>, cargo: Cargo) {
        lines
            .filter { line ->
                line.contains("[")
            }.map { stacks ->
                var count = 0
                stacks
                    .toCharArray()
                    .map {
                        if (it.isLetter())
                            addCrateToStack(cargo, Crate(it), count)
                        count++
                    }
            }
    }

    private fun extractInstructions(lines: List<String>): List<Instruction> {
        return lines
            .filter { line ->
                line.startsWith("move")
            }.map { instruction ->
                val ins = instruction
                    .split(" ")
                Instruction(
                    move = ins[1].toInt(),
                    from = ins[3].toInt(),
                    to = ins[5].toInt()
                )
            }
    }
}