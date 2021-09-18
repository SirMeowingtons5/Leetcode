package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class BinarySearchTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(BinarySearchTestData(intArrayOf(-1,0,3,5,9,12), 9, 4)),
            arguments(BinarySearchTestData(intArrayOf(-1,0,3,5,9,12), 2, -1)),
            arguments(BinarySearchTestData(intArrayOf(), 0, -1)),
            arguments(BinarySearchTestData(intArrayOf(-1,0,3,5,9,12), 13, -1))
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: BinarySearchTestData) {
        val actual = BinarySearch().search(data.nums, data.target)

        assertEquals(data.expected, actual)
    }

    data class BinarySearchTestData(val nums: IntArray, val target: Int, val expected: Int)
}