package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 34,
    title = "Find First and Last Position of Element in Sorted Array",
    link = "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class FindFirstAndLastPositionOfElementInSortedArray {

    fun searchRange(nums: IntArray, target: Int): IntArray {
        var first: Int = -1
        var last: Int = -1

        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            var mid = left + (right - left) / 2

            when{
                nums[mid] < target -> {
                    left = mid + 1
                }
                nums[mid] > target -> {
                    right = mid - 1
                }
                else -> {
                    first = mid
                    right = mid - 1
                }
            }
        }

        if (first == -1) return intArrayOf(-1, -1)

        left = 0
        right = nums.size - 1

        while (left <= right) {
            var mid = left + (right - left) / 2

            when{
                nums[mid] < target -> {
                    left = mid + 1
                }
                nums[mid] > target -> {
                    right = mid - 1
                }
                else -> {
                    last = mid
                    left = mid + 1
                }
            }
        }

        return intArrayOf(first, last)
    }
}