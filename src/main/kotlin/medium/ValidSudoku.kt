package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 36,
    title = "Valid Sudoku",
    link = "https://leetcode.com/problems/valid-sudoku/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class ValidSudoku {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = HashSet<Char>()

        //Square check
        for (v in 0..2) { //all squares in column
            for (h in 0..2) { //all squares in row
                for (i in 0..2) { //each square
                    val hIndex = h * 3 + i
                    for (j in 0..2) {
                        val vIndex = v * 3 + j
                        if (board[hIndex][vIndex] != '.') {
                            if (!set.add(board[hIndex][vIndex])) return false
                        }
                    }
                }
                set.clear()
            }
        }

        //column check
        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j])) return false
                }
            }
            set.clear()
        }

        //row check
        for (i in 0..8) {
            for (j in 0..8) {
                if (board[j][i] != '.') {
                    if (!set.add(board[j][i])) return false
                }
            }
            set.clear()
        }

        return true
    }
}