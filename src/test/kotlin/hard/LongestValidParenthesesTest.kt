package hard

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LongestValidParenthesesTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(LongestValidParenthesesTestData(s = "(()", expected = 2)),
            arguments(LongestValidParenthesesTestData(s = ")()())", expected = 4)),
            arguments(LongestValidParenthesesTestData(s = "", expected = 0)),
            arguments(LongestValidParenthesesTestData(s = "()", expected = 2)),
            arguments(LongestValidParenthesesTestData(s = ")()())()()(", expected = 4)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: LongestValidParenthesesTestData) {
        val actual = LongestValidParentheses().longestValidParentheses(data.s)

        assertEquals(data.expected, actual)
    }

    data class LongestValidParenthesesTestData(val s: String, val expected: Int)
}