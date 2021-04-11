package easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class MovingAverageTest {

    @Test
    fun testAverage() {
        val movingAverage = MovingAverage(3)
        assertEquals(1.0, movingAverage.next(1))
        assertEquals(5.5, movingAverage.next(10))
        assertEquals(4.66667, movingAverage.next(3), 0.0001)
        assertEquals(6.0, movingAverage.next(5))
    }
}