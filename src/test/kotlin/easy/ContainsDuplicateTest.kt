package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ContainsDuplicateTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(ContainsDuplicateTestData(nums = intArrayOf(1,2,3,1), expected = true)),
            arguments(ContainsDuplicateTestData(nums = intArrayOf(1,2,3,4), expected = false)),
            arguments(ContainsDuplicateTestData(nums = intArrayOf(1,1,1,3,3,4,3,2,4,2), expected = true)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ContainsDuplicateTestData) {
        val actual = ContainsDuplicate().containsDuplicate(data.nums)

        assertEquals(data.expected, actual)
    }

    data class ContainsDuplicateTestData(val nums: IntArray, val expected: Boolean)
}