package solutions

class Four: Solution {
    override fun solve(inputs: List<String>) {
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