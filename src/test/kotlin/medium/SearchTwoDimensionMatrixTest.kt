package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class SearchTwoDimensionMatrixTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(SearchTwoDimensionMatrixTestData(matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), target = 3, true)),
            arguments(SearchTwoDimensionMatrixTestData(matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), target = 13, false)),
            arguments(SearchTwoDimensionMatrixTestData(matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), target = 30, true)),
            arguments(SearchTwoDimensionMatrixTestData(matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), target = 61, false)),
            arguments(SearchTwoDimensionMatrixTestData(matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)), target = 0, false)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: SearchTwoDimensionMatrixTestData) {
        val actual = SearchTwoDimensionMatrix().searchMatrix(data.matrix, data.target)

        assertEquals(data.expected, actual)
    }

    data class SearchTwoDimensionMatrixTestData(val matrix: Array<IntArray>, val target: Int, val expected: Boolean)
}