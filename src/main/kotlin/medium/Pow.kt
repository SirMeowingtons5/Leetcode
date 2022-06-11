package medium


/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 */

class Pow {

    fun myPow(x: Double, n: Int): Double {
        var powerAbs: Long = Math.abs(n.toLong())
        var base = x

        var res = 1.0

        while (powerAbs > 0) {
            val isOdd = (powerAbs and 1) == 1L
            if (isOdd) res *= base

            powerAbs /= 2
            base *= base
        }

        return if (n >= 0) res else (1 / res)
    }
}