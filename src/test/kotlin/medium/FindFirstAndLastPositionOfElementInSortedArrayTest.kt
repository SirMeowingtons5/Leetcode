package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindFirstAndLastPositionOfElementInSortedArrayTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                FindFirstAndLastPositionOfElementInSortedArrayTestData(
                    nums = intArrayOf(5, 7, 7, 8, 8, 10),
                    target = 8,
                    expected = intArrayOf(3, 4)
                )
            ),
            arguments(
                FindFirstAndLastPositionOfElementInSortedArrayTestData(
                    nums = intArrayOf(5, 7, 7, 8, 8, 10),
                    target = 6,
                    expected = intArrayOf(-1, -1)
                )
            ),
            arguments(
                FindFirstAndLastPositionOfElementInSortedArrayTestData(
                    nums = intArrayOf(),
                    target = 0,
                    expected = intArrayOf(-1, -1)
                )
            ),

            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FindFirstAndLastPositionOfElementInSortedArrayTestData) {
        val actual = FindFirstAndLastPositionOfElementInSortedArray().searchRange(data.nums, data.target)

        assertArrayEquals(data.expected, actual)
    }

    data class FindFirstAndLastPositionOfElementInSortedArrayTestData(
        val nums: IntArray,
        val target: Int,
        val expected: IntArray
    )
}