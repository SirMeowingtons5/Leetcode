package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 704,
    title = "Binary Search",
    link = "https://leetcode.com/problems/binary-search/",
    difficulty = ProblemDifficulty.EASY,
)
class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        var low = 0
        var high = nums.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val midVal = nums[mid]

            when {
                midVal == target -> return mid
                midVal < target -> low = mid + 1
                midVal > target -> high = mid - 1
            }
        }

        return -1
    }
}