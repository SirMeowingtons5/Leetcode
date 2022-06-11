package easy

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */

class MoveZeroes {

    fun moveZeroes(nums: IntArray) {
        var zeroPointer: Int = nums.indexOfFirstInRange(0, 0, nums.size - 1)

        var i = 0
        while(zeroPointer != -1 && i < nums.size) {
            if (nums[i] != 0 && i > zeroPointer) {
                nums[zeroPointer] = nums[i]
                nums [i] = 0

                zeroPointer = nums.indexOfFirstInRange(0, zeroPointer, nums.size - 1)
            }
            i++
        }
    }

    private fun IntArray.indexOfFirstInRange(element: Int, start: Int, end: Int): Int {
        for (i in start..end) {
            if (get(i) == element) return i
        }
        return -1
    }
}