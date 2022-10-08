package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty


/**
 * You can read my solution here:
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/solutions/2678355/o-1-space-complexity-explained/
 */
@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2149,
    title = "Rearrange Array Elements by Sign",
    link = "https://leetcode.com/problems/rearrange-array-elements-by-sign/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class RearrangeArrayElementsBySign {

    fun rearrangeArray(nums: IntArray): IntArray {
        for (i in nums.indices) {
            val isNegativeAtWrongPlace = i % 2 == 0 && nums[i] < 0
            val isPositiveAtWrongPlace = i % 2 == 1 && nums[i] > 0

            if (isNegativeAtWrongPlace || isPositiveAtWrongPlace) {
                var nearestOppositeIndex = i

                if (isNegativeAtWrongPlace) {
                    while (nums[nearestOppositeIndex] < 0) {
                        nearestOppositeIndex++
                    }
                } else {
                    while (nums[nearestOppositeIndex] >= 0) {
                        nearestOppositeIndex++
                    }
                }

                val nearestOpposite = nums[nearestOppositeIndex]

                for (j in nearestOppositeIndex downTo i + 1) {
                    nums[j] = nums[j - 1]
                }

                nums[i] = nearestOpposite
            }
        }

        return nums
    }
}