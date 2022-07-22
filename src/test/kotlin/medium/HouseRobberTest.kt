package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class HouseRobberTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(HouseRobberTestData(nums = intArrayOf(1,2,3,1), expected = 4)),
            arguments(HouseRobberTestData(nums = intArrayOf(2,7,9,3,1), expected = 12))
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: HouseRobberTestData) {
        val actual = HouseRobber().rob(data.nums)

        assertEquals(data.expected, actual)
    }

    data class HouseRobberTestData(val nums: IntArray, val expected: Int)
}