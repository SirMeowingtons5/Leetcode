package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2221,
    title = "Find Triangular Sum of an Array",
    link = "https://leetcode.com/problems/find-triangular-sum-of-an-array/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class FindTriangularSumOfAnArray {

    fun triangularSum(nums: IntArray): Int {
        for (i in nums.indices) {
            for (j in 0 until nums.size - i - 1) {
                nums[j] = (nums[j] + nums[j+1]) % 10
            }
        }

        return nums[0]
    }
}