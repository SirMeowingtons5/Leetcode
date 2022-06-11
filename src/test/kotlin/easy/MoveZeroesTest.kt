package easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MoveZeroesTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(MoveZeroesTestData(nums = intArrayOf(0,1,0,3,12), expected = intArrayOf(1,3,12,0,0))),
            arguments(MoveZeroesTestData(nums = intArrayOf(0), expected = intArrayOf(0))),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MoveZeroesTestData) {
        MoveZeroes().moveZeroes(data.nums)

        assertArrayEquals(data.expected, data.nums)
    }

    data class MoveZeroesTestData(val nums: IntArray, val expected: IntArray)
}