package easy

/**
 * https://leetcode.com/problems/plus-one/
 */

class PlusOne {

    fun plusOne(digits: IntArray): IntArray {
        val increasedSizeDigits = IntArray(digits.size + 1)
        var rankIncreased = false

        digits[digits.size - 1]++

        for (i in digits.size - 1 downTo 0) {
            var digit = digits[i]
            if (rankIncreased) {
                digit++
            }

            rankIncreased = digit / 10 > 0
            digit %= 10

            increasedSizeDigits[i+1] = digit
        }

        return if(rankIncreased) {
            increasedSizeDigits[0] = 1
            increasedSizeDigits
        } else {
            increasedSizeDigits.copyOfRange(1, increasedSizeDigits.size)
        }
    }
}