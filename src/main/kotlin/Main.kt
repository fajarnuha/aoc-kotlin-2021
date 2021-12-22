import solutions.*
import java.io.File


fun main(args: Array<String>) {
//    val problemNumber = "3_2"
//    val input = File("inputs/$problemNumber.txt").readLines().map { it.trim() }.filter { it.isNotBlank() }
//    val solver = when (problemNumber) {
//        "1_1" -> Day1Part1()
//        "1_2" -> Day1Part2()
//        "2_1" -> Day2Part1()
//        "2_2" -> Day2Part2()
//        "3_1" -> Day3Part1()
//        "3_2" -> Day3Part2()
//        else -> throw IllegalArgumentException("Undefined Problem Number")
//    }
//    solver.solve(input)

    val solver = Day4Part1()
    solver.solve()

}