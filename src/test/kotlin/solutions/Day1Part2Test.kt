package solutions

import org.junit.Test

class Day1Part2Test {

    @Test
    fun `test two`() {
        val solver = Day1Part2()
        solver.solve(listOf(
            "199",
            "200",
            "208",
            "210",
            "200",
            "207",
            "240",
            "269",
            "260",
            "263",
        ))
    }
}