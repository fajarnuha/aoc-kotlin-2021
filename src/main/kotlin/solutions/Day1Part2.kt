package solutions

import java.util.*

class Day1Part2: Solution {

    private val windowSize = 3

    override fun solve(inputs: List<String>) {
        val queue = ArrayDeque<Int>()
        var positives = 0
        for (i in inputs) {
            val prev = queue.sumOrNull()
            queue.popPush(i.toInt())
            val curr = queue.sumOrNull()
            if (prev == null || curr == null) continue
            if (curr > prev) {
                positives++
            }
        }
        println("Solution: $positives")
    }

    private fun ArrayDeque<Int>.popPush(i: Int) {
        if (size == windowSize) {
            removeFirst()
        }
        addLast(i)
    }

    private fun ArrayDeque<Int>.sumOrNull(): Int? = if (size == windowSize) sum() else null
}