package easy

import org.junit.Assert.assertArrayEquals
import org.junit.Test

internal class TwoSumTest {

    private val twoSum = TwoSum()

    @Test
    fun `example 1`() {
        val expected = intArrayOf(0, 1)
        val actual = twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9)

        assertArrayEquals(expected, actual)
    }

    @Test
    fun `example 2`() {
        val expected = intArrayOf(1, 2)
        val actual = twoSum.twoSum(intArrayOf(3, 2, 4), 6)

        assertArrayEquals(expected, actual)
    }

    fun `example 3`() {
        val expected = intArrayOf(3, 3)
        val actual = twoSum.twoSum(intArrayOf(3, 3), 6)

        assertArrayEquals(expected, actual)
    }
}