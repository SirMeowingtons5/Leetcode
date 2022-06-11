package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class SingleNumberTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(SingleNumberTestData(nums = intArrayOf(2,2,1), expected = 1)),
                arguments(SingleNumberTestData(nums = intArrayOf(4,1,2,1,2), expected = 4)),
                arguments(SingleNumberTestData(nums = intArrayOf(1), expected = 1)),

                )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: SingleNumberTestData) {
        val actual = SingleNumber().singleNumber(data.nums)

        assertEquals(data.expected, actual)
    }


    data class SingleNumberTestData(val nums: IntArray, val expected: Int)
}