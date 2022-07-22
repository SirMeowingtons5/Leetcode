package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 48,
    title = "Rotate Image",
    link = "https://leetcode.com/problems/rotate-image/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class RotateImage {

    fun rotate(matrix: Array<IntArray>) {
        val max = matrix.size - 1

        for (i in 0..matrix.size / 2 ) {
            for (j in i until matrix.size - 1 - i) {
                val temp = matrix[i][j] //save 1st
                matrix[i][j] = matrix[max - j][i] //write 4th to 1st
                matrix[max-j][i] = matrix[max-i][max-j] //write 3rd to 4th
                matrix[max-i][max-j] = matrix[j][max-i] //write 2nd to 3rd
                matrix[j][max-i] = temp //write 1st to 2nd
            }
        }
    }
}