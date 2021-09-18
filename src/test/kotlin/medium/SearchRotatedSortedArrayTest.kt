package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class SearchRotatedSortedArrayTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(SearchRotatedSortedArrayTestData(nums = intArrayOf(4,5,6,7,0,1,2), target = 0, expected = 4)),
            arguments(SearchRotatedSortedArrayTestData(nums = intArrayOf(4,5,6,7,0,1,2), target = 3, expected = -1)),
            arguments(SearchRotatedSortedArrayTestData(nums = intArrayOf(1), target = 0, expected = -1)),
            arguments(SearchRotatedSortedArrayTestData(nums = intArrayOf(1, 3), target = 0, expected = -1)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: SearchRotatedSortedArrayTestData) {
        val actual = SearchRotatedSortedArray().search(data.nums, data.target)

        assertEquals(data.expected, actual)
    }

    data class SearchRotatedSortedArrayTestData(val nums: IntArray, val target: Int, val expected: Int)
}