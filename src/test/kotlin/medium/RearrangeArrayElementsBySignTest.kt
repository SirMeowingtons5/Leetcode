package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RearrangeArrayElementsBySignTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                RearrangeArrayElementsBySignTestData(
                    nums = intArrayOf(3, 1, -2, -5, 2, -4),
                    expected = intArrayOf(3, -2, 1, -5, 2, -4),
                )
            ),
            arguments(
                RearrangeArrayElementsBySignTestData(
                    nums = intArrayOf(-1, 1),
                    expected = intArrayOf(1, -1),
                )
            ),
            arguments(
                RearrangeArrayElementsBySignTestData(
                    nums = intArrayOf(3,11,-47,29,18,-4,-26,16,15,-47,4,-22,41,-36,-27,-32),
                    expected = intArrayOf(3, -47, 11, -4, 29, -26, 18, -47, 16, -22, 15, -36, 4, -27, 41, -32),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: RearrangeArrayElementsBySignTestData) {
        val actual = RearrangeArrayElementsBySign().rearrangeArray(data.nums)

        assertArrayEquals(data.expected, actual)
    }

    data class RearrangeArrayElementsBySignTestData(val nums: IntArray, val expected: IntArray)
}