package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1630,
    title = "Arithmetic Subarrays",
    link = "https://leetcode.com/problems/arithmetic-subarrays/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class ArithmeticSubarrays {

    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        val res = ArrayList<Boolean>()

        for (i in l.indices) {
            val isArithmetic: Boolean = if (r[i] - l[i] + 1 >= 2) {
                isArrayArithmetic(nums.copyOfRange(l[i], r[i]+1).apply { sort() })
            } else {
                false
            }
            res.add(isArithmetic)
        }

        return res
    }

    private fun isArrayArithmetic(array: IntArray): Boolean {
        val expectedDiff = array[0] - array[1]
        for (i in 0 until array.size - 1) {
            if (array[i] - array[i + 1] != expectedDiff) return false
        }

        return true
    }
}