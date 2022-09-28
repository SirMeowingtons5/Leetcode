package easy

import org.junit.Assert.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MergeSortedArraysTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MergeSortedArraysTestData(
                    num1 = intArrayOf(1, 2, 3, 0, 0, 0),
                    m = 3,
                    num2 = intArrayOf(2, 5, 6),
                    n = 3,
                    expected = intArrayOf(1, 2, 2, 3, 5, 6),
                ),
                MergeSortedArraysTestData(
                    num1 = intArrayOf(1),
                    m = 1,
                    num2 = intArrayOf(),
                    n = 0,
                    expected = intArrayOf(1)
                ),
                MergeSortedArraysTestData(
                    num1 = intArrayOf(0),
                    m = 0,
                    num2 = intArrayOf(1),
                    n = 1,
                    expected = intArrayOf(1)
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MergeSortedArraysTestData) {
        MergeSortedArrays().merge(data.num1, data.m, data.num2, data.n)

        assertArrayEquals(data.expected, data.num1)
    }

    data class MergeSortedArraysTestData(
        val num1: IntArray,
        val m: Int,
        val num2: IntArray,
        val n: Int,
        val expected: IntArray
    )
}