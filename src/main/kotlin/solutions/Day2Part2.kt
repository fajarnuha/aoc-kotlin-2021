package solutions

import parseInput

class Day2Part2: Solution {

    override val inputFileName: String = "2_2.txt"

    override fun solve() {
        val inputs = parseInput(inputFileName)
        var horizontal = 0
        var depth = 0
        var aim = 0

        for (input in inputs) {
            val (cmd, v) = input.split(" ")
            when (cmd) {
                "forward" -> {
                    horizontal += v.toInt()
                    depth += (aim * v.toInt())
                }
                "up" -> aim -= v.toInt()
                "down" -> aim += v.toInt()
                else -> throw IllegalStateException()
            }
        }
        println("Result x: $horizontal y: $depth x.y: ${horizontal*depth}")
    }
}