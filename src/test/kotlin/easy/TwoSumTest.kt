package easy

import org.junit.Assert.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class TwoSumTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
                arguments(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
                arguments(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(nums: IntArray, target: Int, expected: IntArray) {
        assertArrayEquals(expected, TwoSum().twoSum(nums, target))
    }
}