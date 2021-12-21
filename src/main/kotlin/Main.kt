import solutions.Four
import solutions.One
import solutions.Three
import solutions.Two
import java.io.File


fun main(args: Array<String>) {
    val problemNumber = "2_1"
    val input = File("inputs/$problemNumber.txt").readLines().map { it.trim() }.filter { it.isNotBlank() }
    val solver = when (problemNumber) {
        "1" -> One()
        "2" -> Two()
        "3" -> Three()
        "2_1" -> Four()
        else -> throw IllegalArgumentException("Undefined Problem Number")
    }
    solver.solve(input)

}