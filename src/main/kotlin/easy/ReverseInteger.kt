package easy

/**
 * https://leetcode.com/problems/reverse-integer/
 */

class ReverseInteger {
    fun reverse(x: Int): Int {
        var result = 0L
        var currentNumber = x

        do {
            result *= 10
            result += currentNumber % 10
            currentNumber /= 10
        } while (currentNumber != 0)

        return if (result > Int.MAX_VALUE || result < Int.MIN_VALUE) 0 else result.toInt()
    }
}