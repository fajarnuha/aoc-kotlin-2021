package solutions

import java.util.*

class Two: Solution {
    override fun solve(inputs: List<String>) {
        val queue = ArrayDeque<Int>()
        var positives = 0
        for (i in inputs) {
            val prev = if (queue.size == 3) queue.sum() else null
            queue.popPush(i.toInt())
            val curr = if (queue.size == 3) queue.sum() else null
            if (prev == null || curr == null) continue
            if (curr > prev) {
                positives++
            }
        }
        println("Solution: $positives")
    }

    private fun ArrayDeque<Int>.popPush(i: Int) {
        if (size == 3) {
            removeFirst()
        }
        addLast(i)
    }
}