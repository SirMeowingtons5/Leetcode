package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class BestTimeToBuyAndSellStock2Test {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(BestTimeToBuyAndSellStock2TestData(prices = intArrayOf(7,1,5,3,6,4), expected = 7)),
            arguments(BestTimeToBuyAndSellStock2TestData(prices = intArrayOf(1,2,3,4,5), expected = 4)),
            arguments(BestTimeToBuyAndSellStock2TestData(prices = intArrayOf(7,6,4,3,1), expected = 0)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: BestTimeToBuyAndSellStock2TestData) {
        val actual = BestTimeToBuyAndSellStock2().maxProfit(data.prices)

        assertEquals(data.expected, actual)
    }

    data class BestTimeToBuyAndSellStock2TestData(
        val prices: IntArray,
        val expected: Int,
    )
}