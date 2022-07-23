package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MinCostClimbingStairsTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(MinCostClimbingStairsTestData(cost = intArrayOf(10,15,20), expected = 15)),
            arguments(MinCostClimbingStairsTestData(cost = intArrayOf(1,100,1,1,1,100,1,1,100,1), expected = 6))
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MinCostClimbingStairsTestData) {
        val actual = MinCostClimbingStairs().minCostClimbingStairs(data.cost)

        assertEquals(data.expected, actual)
    }

    data class MinCostClimbingStairsTestData(val cost: IntArray, val expected: Int)
}