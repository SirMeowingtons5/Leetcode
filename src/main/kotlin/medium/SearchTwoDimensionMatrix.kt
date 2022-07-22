package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 74,
    title = "Search a 2D Matrix",
    link = "https://leetcode.com/problems/search-a-2d-matrix/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class SearchTwoDimensionMatrix {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val rowIndex = findRowIndex(matrix, target)

        return if(rowIndex != null) {
            binaryContains(matrix[rowIndex], target)
        } else {
            false
        }
    }

    private fun findRowIndex(matrix: Array<IntArray>, target: Int): Int? {
        if (matrix[0][0] > target) return null

        var currentIndex = 0

        while (currentIndex < matrix.size - 1 && target >= matrix[currentIndex + 1][0]) {
            currentIndex++
        }

        return currentIndex
    }

    private fun binaryContains(array: IntArray, target: Int): Boolean {
        var low = 0
        var high = array.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val midVal = array[mid]

            when {
                midVal > target -> high = mid - 1
                midVal < target -> low = mid + 1
                midVal == target -> return true
            }
        }

        return false
    }
}