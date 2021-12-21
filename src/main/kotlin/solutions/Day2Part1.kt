package solutions

class Day2Part1: Solution {

    override fun solve(inputs: List<String>) {
        var horizontal = 0
        var depth = 0

        for (input in inputs) {
            val (cmd, v) = input.split(" ")
            when (cmd) {
                "forward" -> horizontal += v.toInt()
                "up" -> depth -= v.toInt()
                "down" -> depth += v.toInt()
                else -> throw IllegalStateException()
            }
        }
        println("Result x: $horizontal y: $depth x.y: ${horizontal*depth}")
    }
}