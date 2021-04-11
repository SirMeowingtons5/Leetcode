package easy

import java.util.*

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 */

class MovingAverage(private val size: Int) {

    private val list = LinkedList<Int>()
    private var sum = 0.0

    fun next(`val`: Int): Double {
        if(list.size == size) {
            sum -= list[0]
            list.removeAt(0)
        }

        list.add(`val`)
        sum += `val`

        return sum / list.size
    }
}