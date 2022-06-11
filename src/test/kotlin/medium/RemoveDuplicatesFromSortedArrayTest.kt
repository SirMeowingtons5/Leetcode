package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class RemoveDuplicatesFromSortedArrayTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(RemoveDuplicatesFromSortedArrayTestData(nums = intArrayOf(1, 1, 2), expected = intArrayOf(1, 2))),
            arguments(
                RemoveDuplicatesFromSortedArrayTestData(
                    nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4),
                    expected = intArrayOf(0, 1, 2, 3, 4)
                )
            )
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: RemoveDuplicatesFromSortedArrayTestData) {
        val actual = RemoveDuplicatesFromSortedArray().removeDuplicates(data.nums)

        assertEquals(data.expected.size, actual)

        for(i in 0 until actual) {
            assertEquals(data.expected[i], data.nums[i])
        }
    }

    data class RemoveDuplicatesFromSortedArrayTestData(
        val nums: IntArray,
        val expected: IntArray,
    )
}