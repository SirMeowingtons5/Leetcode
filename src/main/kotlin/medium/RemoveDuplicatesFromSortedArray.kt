package medium

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

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