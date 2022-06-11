package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RotateArrayTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                RotateArrayTestData(
                    nums = intArrayOf(1, 2, 3, 4, 5, 6, 7),
                    k = 3,
                    expected = intArrayOf(5, 6, 7, 1, 2, 3, 4)
                )
            ),
            arguments(
                RotateArrayTestData(
                    nums = intArrayOf(-1, -100, 3, 99),
                    k = 2,
                    expected = intArrayOf(3, 99, -1, -100)
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: RotateArrayTestData) {
        RotateArray().rotate(data.nums, data.k)

        assertArrayEquals(data.expected, data.nums)
    }


    data class RotateArrayTestData(val nums: IntArray, val k: Int, val expected: IntArray)
}