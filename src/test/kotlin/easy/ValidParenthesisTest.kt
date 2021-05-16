package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class ValidParenthesisTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments("()[]{}", true),
                arguments("(]", false),
                arguments("([)]", false),
                arguments("{[]}", true)
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(s: String, expected: Boolean) {
        val actual = ValidParenthesis().isValid(s)

        kotlin.test.assertEquals(expected, actual)
    }
}