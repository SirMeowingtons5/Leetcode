package easy

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * Don't forget to remove constructor argument from GuessNumber before submitting
 * It was added purely for testing purposes
 */

class GuessNumber(pick: Int) : GuessGame(pick) {

    override fun guessNumber(n: Int): Int {
        var low = 1
        var high = n

        while (low <= high) {
            val mid = ((low.toLong() + high.toLong()) / 2).toInt()

            when (guess(mid)) {
                -1 -> high = mid - 1
                1 -> low = mid + 1
                0 -> return mid
            }
        }

        throw IllegalStateException("Pick is out of bounds [1 ; $n]")
    }
}

/**
 * Util class that shouldn't be in your submission
 */

abstract class GuessGame(private val pick: Int) {

    abstract fun guessNumber(n: Int): Int

    fun guess(num: Int): Int = when {
        pick > num -> 1
        pick < num -> -1
        else -> 0
    }
}