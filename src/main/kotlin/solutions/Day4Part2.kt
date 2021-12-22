package solutions

import java.io.File

class Day4Part2: Solution {

    override val inputFileName = "4.txt"

    override fun solve() {

        val input = File("inputs/$inputFileName").readText().split("\n\n")

        val sequence = input.first().split(",").map { it.toInt() }

        val boards = input.slice(1 until input.size).map { rawBoard ->
            rawBoard.split("\n").toTypedArray().map { row ->
                row.trim().split("""\s+""".toRegex()).map { rawCol ->
                    rawCol.toInt() to false
                }.toMutableList()
            }
        }.toMutableList()

        var result = -1
        val blacklist = mutableListOf<Int>()
        run outer@{
            sequence.forEach { num ->
                boards.forEachIndexed { i, board ->
                    if (blacklist.contains(i)) return@forEachIndexed
                    markBoard(num, board)
                    val bingo = scanBoard(board)
                    if (bingo) {
                        if (blacklist.size == boards.size - 1) {
                            result = scoreBoard(num, board)
                            return@outer
                        }
                        blacklist += i
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