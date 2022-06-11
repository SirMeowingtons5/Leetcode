package easy


/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val set = LinkedHashMap<Int, Int>()

        nums.forEach { num ->
            if (set.contains(num)) {
                set[num] = 2
            } else {
                set[num] = 1
            }
        }

        set.keys.forEach { number ->
            val diff = target - number
            when {
                diff == number && set[number] == 2 -> return intArrayOf(
                    nums.indexOfFirst { it == number },
                    nums.indexOfLast { it == number },
                )
                diff != number && set.contains(diff) -> return intArrayOf(nums.indexOf(number), nums.indexOf(diff)).sortedArray()
                else -> Unit
            }
        }

        throw Exception("No solution")
    }
}