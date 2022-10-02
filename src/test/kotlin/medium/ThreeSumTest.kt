package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ThreeSumTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                ThreeSumTestData(
                    nums = intArrayOf(-1, 0, 1, 2, -1, -4),
                    expected = listOf(
                        listOf(-1, -1, 2),
                        listOf(-1, 0, 1)
                    )
                )
            ),
            arguments(
                ThreeSumTestData(
                    nums = intArrayOf(0,1,1),
                    expected = emptyList()
                )
            ),

        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ThreeSumTestData) {
        val actual = ThreeSum().threeSum(data.nums)

        assertEquals(data.expected, actual)
    }

    data class ThreeSumTestData(val nums: IntArray, val expected: List<List<Int>>)
}