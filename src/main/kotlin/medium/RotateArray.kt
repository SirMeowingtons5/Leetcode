package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 189,
    title = "Rotate Array",
    link = "https://leetcode.com/problems/rotate-array/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class RotateArray {

    fun rotate(nums: IntArray, k: Int) {
        val rotationsNum = k % nums.size

        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, rotationsNum - 1)
        reverse(nums, rotationsNum, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end
        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }
}