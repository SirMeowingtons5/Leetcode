package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 26,
    title = "Remove Duplicates from Sorted Array",
    link = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class RemoveDuplicatesFromSortedArray {


    fun removeDuplicates(nums: IntArray): Int {
        var pointer = 0

        nums.forEach { num ->
            if (nums[pointer] != num) {
                pointer++
                nums[pointer] = num
            }
        }

        return pointer + 1
    }
}