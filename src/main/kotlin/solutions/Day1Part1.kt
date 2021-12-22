package solutions

import parseInput

class Day1Part1 : Solution {
    override val inputFileName: String = "1_1.txt"

    override fun solve() {
        val inputs = parseInput(inputFileName)
        var back: Int? = null
        var positive = 0
        for (i in inputs) {
            val current = i.toIntOrNull() ?: throw IllegalArgumentException("Can not have non integer input")
            if (back != null && current > back) positive++
            back = current
        }
        println("Solution: $positive")
    }
}