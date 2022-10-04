package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class NumberOfPairsOfStringsWithConcatenationEqualToTargetTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(NumberOfPairsOfStringsWithConcatenationEqualToTargetTestData(nums = arrayOf("777","7","77","77"), target = "7777", expected = 4)),
            arguments(NumberOfPairsOfStringsWithConcatenationEqualToTargetTestData(nums = arrayOf("123","4","12","34"), target = "1234", expected = 2)),
            arguments(NumberOfPairsOfStringsWithConcatenationEqualToTargetTestData(nums = arrayOf("1","1","1"), target = "11", expected = 6)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: NumberOfPairsOfStringsWithConcatenationEqualToTargetTestData) {
        val actual = NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(data.nums, data.target)

        assertEquals(data.expected, actual)
    }

    data class NumberOfPairsOfStringsWithConcatenationEqualToTargetTestData(val nums: Array<String>, val target: String, val expected: Int)
}