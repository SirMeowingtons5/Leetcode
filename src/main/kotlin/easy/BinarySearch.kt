package easy

/**
 * https://leetcode.com/problems/binary-search/
 */

class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return -1

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