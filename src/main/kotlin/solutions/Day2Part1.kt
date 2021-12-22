package solutions

import parseInput

class Day2Part1: Solution {

    override val inputFileName: String = "2_1.txt"

    override fun solve() {
        val inputs = parseInput(inputFileName)
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