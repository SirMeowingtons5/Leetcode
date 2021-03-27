package easy


/**
 * https://leetcode.com/problems/two-sum/
 */

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        nums.forEachIndexed { index, item ->
            for (secondIndex in index + 1 until nums.size) {
                if (nums[index] + nums[secondIndex] == target) return intArrayOf(index, secondIndex)
            }
        }

        throw Exception("No solution")
    }
}