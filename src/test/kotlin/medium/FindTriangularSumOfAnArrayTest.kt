package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class FindTriangularSumOfAnArrayTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                FindTriangularSumOfAnArrayTestData(
                    nums = intArrayOf(1, 2, 3, 4, 5),
                    expected = 8,
                )
            ),
            arguments(
                FindTriangularSumOfAnArrayTestData(
                    nums = intArrayOf(5),
                    expected = 5,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FindTriangularSumOfAnArrayTestData) {
        val actual = FindTriangularSumOfAnArray().triangularSum(data.nums)

        assertEquals(data.expected, actual)
    }

    data class FindTriangularSumOfAnArrayTestData(val nums: IntArray, val expected: Int)
}