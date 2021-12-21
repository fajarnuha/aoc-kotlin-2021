package solutions


class Day1Part1: Solution{
    override fun solve(inputs: List<String>) {
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