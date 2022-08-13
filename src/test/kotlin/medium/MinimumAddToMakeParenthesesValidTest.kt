package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MinimumAddToMakeParenthesesValidTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(MinimumAddToMakeParenthesesValidTestData(s = "())", expected = 1)),
            arguments(MinimumAddToMakeParenthesesValidTestData(s = "(((", expected = 3)),
            arguments(MinimumAddToMakeParenthesesValidTestData(s = "()))((", expected = 4)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MinimumAddToMakeParenthesesValidTestData) {
        val actual = MinimumAddToMakeParenthesesValid().minAddToMakeValid(data.s)

        assertEquals(data.expected, actual)
    }

    data class MinimumAddToMakeParenthesesValidTestData(val s: String, val expected: Int)
}