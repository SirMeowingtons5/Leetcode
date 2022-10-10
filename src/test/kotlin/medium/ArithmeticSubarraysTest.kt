package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ArithmeticSubarraysTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                ArithmeticSubarraysTestData(
                    nums = intArrayOf(4, 6, 5, 9, 3, 7),
                    l = intArrayOf(0, 0, 2),
                    r = intArrayOf(2, 3, 5),
                    expected = listOf(true, false, true)
                )
            ),
            arguments(
                ArithmeticSubarraysTestData(
                    nums = intArrayOf(-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10),
                    l = intArrayOf(0, 1, 6, 4, 8, 7),
                    r = intArrayOf(4, 4, 9, 7, 9, 10),
                    expected = listOf(false, true, false, false, true, true)
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ArithmeticSubarraysTestData) {
        val actual = ArithmeticSubarrays().checkArithmeticSubarrays(data.nums, data.l, data.r)

        assertEquals(data.expected, actual)
    }

    data class ArithmeticSubarraysTestData(
        val nums: IntArray,
        val l: IntArray,
        val r: IntArray,
        val expected: List<Boolean>,
    )
}