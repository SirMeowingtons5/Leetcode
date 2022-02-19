package hard

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

class MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(n: IntArray, m: IntArray): Double {
        var counter = if ((n.size + m.size) % 2 == 0) {
            (m.size + n.size) / 2
        } else {
            (m.size + n.size) / 2 + 1
        }

        var firstPointer = 0
        var secondPointer = 0


        var lastValue = 0
        while (counter != 0) {
            counter--
            when {
                (firstPointer <= (n.size - 1)) && (secondPointer <= (m.size - 1)) -> {
                    if (n[firstPointer] < m[secondPointer]) {
                        lastValue = n[firstPointer]
                        firstPointer++
                    } else {
                        lastValue = m[secondPointer]
                        secondPointer++
                    }
                }
                (firstPointer == n.size) -> {
                    lastValue = m[secondPointer]
                    secondPointer++
                }
                else -> {
                    lastValue = n[firstPointer]
                    firstPointer++
                }
            }
        }

        return if ((n.size + m.size) % 2 != 0) {
            lastValue.toDouble()
        } else {
            val secondMedianValue = when {
                (firstPointer <= n.size - 1 && secondPointer <= m.size - 1) -> minOf(n[firstPointer], m[secondPointer])
                firstPointer <= n.size - 1 -> n[firstPointer]
                else -> m[secondPointer]
            }

            (lastValue.toDouble() + secondMedianValue.toDouble()) / 2
        }
    }
}