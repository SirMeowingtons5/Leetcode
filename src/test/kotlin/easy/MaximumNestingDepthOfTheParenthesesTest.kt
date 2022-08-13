package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MaximumNestingDepthOfTheParenthesesTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(MaximumNestingDepthOfTheParenthesesTestData(s = "(1+(2*3)+((8)/4))+1", expected = 3)),
            arguments(MaximumNestingDepthOfTheParenthesesTestData(s = "(1)+((2))+(((3)))", expected = 3)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MaximumNestingDepthOfTheParenthesesTestData) {
        val actual = MaximumNestingDepthOfTheParentheses().maxDepth(data.s)

        assertEquals(data.expected, actual)
    }

    data class MaximumNestingDepthOfTheParenthesesTestData(val s: String, val expected: Int)
}