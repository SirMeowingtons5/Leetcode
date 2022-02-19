package hard

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MedianOfTwoSortedArraysTest {

    companion object {


        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
//            arguments(MedianOfTwoSortedArraysTestData(n = intArrayOf(1, 3), m = intArrayOf(2), expected = 2.0)),
//            arguments(MedianOfTwoSortedArraysTestData(n = intArrayOf(1, 2), m = intArrayOf(3, 4), expected = 2.5)),
            arguments(MedianOfTwoSortedArraysTestData(n = intArrayOf(1, 3), m = intArrayOf(2, 7), expected = 2.5))
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MedianOfTwoSortedArraysTestData) {
        val actual = MedianOfTwoSortedArrays().findMedianSortedArrays(data.n, data.m)

        assertEquals(data.expected, actual)
    }

    data class MedianOfTwoSortedArraysTestData(val n: IntArray, val m: IntArray, val expected: Double)
}