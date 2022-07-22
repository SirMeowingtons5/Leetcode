package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 118,
    title = "Pascal's Triangle",
    link = "https://leetcode.com/problems/pascals-triangle/",
    difficulty = ProblemDifficulty.EASY,
)
class PascalsTriangle {

    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        generate(numRows - 1, res)

        return res
    }

    private fun generate(row: Int, triangle: MutableList<List<Int>>) {
        if (row > triangle.size) generate(row - 1, triangle)

        val res = ArrayList<Int>().apply { add(1) }
        var head = 1
        var previous = 0

        for (i in 1 until row) {
            res.add(triangle[row - 1][previous] + triangle[row - 1][head])
            head++
            previous++
        }

        if (row > 0) res.add(1)

        triangle.add(res)
    }
}