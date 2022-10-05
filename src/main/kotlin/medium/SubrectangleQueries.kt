package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1476,
    title = "Subrectangle Queries",
    link = "https://leetcode.com/problems/subrectangle-queries/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class SubrectangleQueries(private val rectangle: Array<IntArray>) {

    fun updateSubrectangle(row1: Int, col1: Int, row2: Int, col2: Int, newValue: Int) {
        for (row in row1..row2) {
            for (col in col1..col2) {
                rectangle[row][col] = newValue
            }
        }
    }

    fun getValue(row: Int, col: Int): Int =
        rectangle[row][col]
}