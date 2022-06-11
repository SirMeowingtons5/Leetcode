package easy

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 */

class ContainsDuplicate {

    fun containsDuplicate(nums: IntArray): Boolean {

        val set = HashSet<Int>()

        nums.forEach {number ->
            if (set.contains(number)) return true
            set.add(number)
        }

        return false
    }
}