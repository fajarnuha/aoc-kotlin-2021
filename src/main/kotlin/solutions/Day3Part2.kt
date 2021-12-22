package solutions

class Day3Part2 : Solution {

    override fun solve(inputs: List<String>) {
        val oxy = filterOxygen(inputs, 0).first()
        val co2 = filterCO2(inputs, 0).first()

        val result = Integer.parseInt(oxy, 2) * Integer.parseInt(co2, 2)

        println("Result: $result")
    }

    private fun filterOxygen(inputs: List<String>, pos: Int): List<String> {
        val half = inputs.size / 2.0
        val ones = inputs.count { it[pos] == '1' }

        val major = when {
            ones > half -> '1'
            ones.toDouble() == half -> '1'
            else -> '0'
        }

        val result = inputs.filter { it[pos] == major }
        return if (result.size == 1) {
            result
        } else {
            filterOxygen(result, pos + 1)
        }
    }

    private fun filterCO2(inputs: List<String>, pos: Int): List<String> {
        val half = inputs.size / 2.0
        val ones = inputs.count { it[pos] == '1' }

        val major = when {
            ones < half -> '1'
            ones.toDouble() == half -> '0'
            else -> '0'
        }

        val result = inputs.filter { it[pos] == major }
        return if (result.size == 1) {
            result
        } else {
            filterCO2(result, pos + 1)
        }
    }

}