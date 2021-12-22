import solutions.*
import java.io.File

fun main(args: Array<String>) {
    println("Arguments: ${args.joinToString()}")
    val solver = when (args.first()) {
        "1_1" -> Day1Part1()
        "1_2" -> Day1Part2()
        "2_1" -> Day2Part1()
        "2_2" -> Day2Part2()
        "3_1" -> Day3Part1()
        "3_2" -> Day3Part2()
        "4_1" -> Day4Part1()
        "4_2" -> Day4Part2()
        else -> throw IllegalArgumentException("Undefined Problem Number")
    }
    solver.solve()

}