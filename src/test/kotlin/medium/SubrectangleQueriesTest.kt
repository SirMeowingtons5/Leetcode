package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SubrectangleQueriesTest {

    @Test
    fun `test case 1`() {
        val instance = SubrectangleQueries(
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(4, 3, 4),
                intArrayOf(3, 2, 1),
                intArrayOf(1, 1, 1),
            )
        )

        assertEquals(1, instance.getValue(0, 2))
        instance.updateSubrectangle(0, 0, 3, 2, 5)
        assertEquals(5, instance.getValue(0, 2))
        assertEquals(5, instance.getValue(3, 1))
        instance.updateSubrectangle(3, 0, 3, 2, 10)
        assertEquals(10, instance.getValue(3, 1))
        assertEquals(5, instance.getValue(0, 2))
    }
}