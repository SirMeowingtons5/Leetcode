package easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PlusOneTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
                arguments(intArrayOf(4,3,2,1), intArrayOf(4,3,2,2)),
                arguments(intArrayOf(9,9,9), intArrayOf(1,0,0,0)),
                arguments(intArrayOf(0), intArrayOf(1))
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(digits: IntArray, expected: IntArray) {
        val actual = PlusOne().plusOne(digits)

        assertEquals(expected.toList(), actual.toList())
    }
}