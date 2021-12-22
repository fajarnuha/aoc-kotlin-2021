package solutions

import java.io.File

class Day4Part2 {

    private val inputFileName = "4.txt"

    fun solve() {

        val input = File("inputs/$inputFileName").readText().split("\n\n")
        var bingoCount = 0

        val sequence = input.first().split(",").map { it.toInt() }

        val boards = input.slice(1 until input.size).map { rawBoard ->
            rawBoard.split("\n").toTypedArray().map { row ->
                row.trim().split("""\s+""".toRegex()).map { rawCol ->
                    rawCol.toInt() to false
                }.toMutableList()
            }
        }.toMutableList()

        var result = -1
        run outer@{
            sequence.forEach { num ->
                boards.forEach {
                    markBoard(num, it)
                    val bingo = scanBoard(it)
                    if (bingo) {
                        bingoCount += 1
                        if (bingoCount == boards.size) {
                            result = scoreBoard(num, it)
                            return@outer
                        }
                    }
                }
            }
        }
        println("Result = $result")
    }


    private fun markBoard(number: Int, board: List<MutableList<Pair<Int, Boolean>>>) {
        for (x in board.indices) {
            for (y in board[x].indices) {
                if (board[x][y].first == number) {
                    board[x][y] = board[x][y].copy(second = true)
                }
            }
        }
    }

    private fun scanBoard(board: List<MutableList<Pair<Int, Boolean>>>): Boolean {
        for (x in board.indices) {
            var bingoX = true
            for (y in board[x].indices) {
                if (!board[x][y].second) {
                    bingoX = false
                }

                if (x == board.lastIndex) {
                    val yMarks = board.map { it[y].second }
                    if (yMarks.all { it }) return true
                }
            }
            if (bingoX) return true
        }
        return false
    }

    private fun scoreBoard(number: Int, board: List<MutableList<Pair<Int, Boolean>>>): Int {
        val unMarked = mutableListOf<Int>()
        for (x in board.indices) {
            for (y in board[x].indices) {
                if (board[x][y].second.not()) {
                    unMarked += board[x][y].first
                }
            }
        }

        return number * unMarked.sum()
    }

}