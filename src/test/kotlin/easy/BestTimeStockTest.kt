package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class BestTimeStockTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(BestTimeStockSampleData(intArrayOf(7,1,5,3,6,4), 5)),
                arguments(BestTimeStockSampleData(intArrayOf(7,6,4,3,1), 0)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: BestTimeStockSampleData) {
        val actual = BestTimeStock().maxProfit(data.prices)

        assertEquals(data.expected, actual)
    }


    data class BestTimeStockSampleData(val prices: IntArray, val expected: Int)
}