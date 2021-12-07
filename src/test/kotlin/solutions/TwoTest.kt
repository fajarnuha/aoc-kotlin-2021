package solutions

import org.junit.Assert.*
import org.junit.Test

class TwoTest {

    @Test
    fun `test two`() {
        val solver = Two()
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