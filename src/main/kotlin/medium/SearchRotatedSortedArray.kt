package medium

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

class SearchRotatedSortedArray {

    fun search(nums: IntArray, target: Int): Int {
        if(nums.size == 1) return if (nums[0]  == target) 0 else -1

        val rotationIndex = findRotationIndex(nums)

        val targetIsBeforeRotationPoint = target > nums.last()

        val subArray = if (targetIsBeforeRotationPoint) {
            nums.take(rotationIndex + 1)
        } else {
            nums.takeLast(nums.size - rotationIndex)
        }

        val indexInSubArray = binarySearch(subArray, target)

        return when {
            !targetIsBeforeRotationPoint && indexInSubArray != -1 -> indexInSubArray + rotationIndex //add offset for right sub array index
            else -> indexInSubArray
        }
    }

    private fun findRotationIndex(nums: IntArray): Int {
        var low = 0
        var high = nums.size - 1

        if (nums[low] < nums[high]) return 0

        while (low <= high) {
            val mid = (low + high) / 2

            when {
                nums[mid] > nums[mid + 1] -> return mid + 1
                nums[mid] < nums[low] -> high = mid -1
                else -> low = mid + 1
            }
        }

        return 0
    }

    private fun binarySearch(nums: List<Int>, target: Int): Int {
        var low = 0
        var high = nums.size - 1

        while (low <= high) {
            val mid = (low + high) / 2
            val midVal = nums[mid]

            when {
                midVal < target -> low = mid + 1
                midVal > target -> high = mid - 1
                midVal == target -> return mid
            }
        }

        return -1
    }
}