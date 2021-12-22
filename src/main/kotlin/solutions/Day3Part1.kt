package solutions

class Day3Part1 : Solution {
    override fun solve(inputs: List<String>) {
        var gamma = ""
        var epsilon = ""
        var size = 0

        val ones = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

        for (input in inputs) {
            size += 1
            for ((i, c) in input.withIndex()) {
                if (c == '1') ones[i] += 1
            }
        }

        val half = size / 2
        ones.forEach { i ->
            gamma += if (i > half) "1" else "0"
            epsilon += if (i < half) "1" else "0"
        }
        val gammaInt = Integer.parseInt(gamma, 2)
        val epsilonInt = Integer.parseInt(epsilon, 2)
        val consumption = gammaInt * epsilonInt
        println("Result gamma: $gamma, epsilon: $epsilon, consumption: $consumption")
    }
}