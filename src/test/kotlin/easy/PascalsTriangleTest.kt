package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class PascalsTriangleTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                PascalsTriangleTestData(numRows = 5, expected = listOf(listOf(1), listOf(1, 1), listOf(1,2,1), listOf(1,3,3,1), listOf(1,4,6,4,1))),
                PascalsTriangleTestData(numRows = 1, expected = listOf(listOf(1)))
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: PascalsTriangleTestData) {
        val actual = PascalsTriangle().generate(data.numRows)

        assertEquals(data.expected, actual)
    }

    data class PascalsTriangleTestData(val numRows: Int, val expected: List<List<Int>>)
}