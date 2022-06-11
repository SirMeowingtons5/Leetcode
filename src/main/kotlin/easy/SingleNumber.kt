package easy

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 */

class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        var res = 0

        nums.forEach {number ->
            res = res.xor(number)
        }

        return res
    }
}