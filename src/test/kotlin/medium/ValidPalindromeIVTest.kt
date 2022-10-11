package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ValidPalindromeIVTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                ValidPalindromeIVTestData(
                    s = "abcdba",
                    expected = true,
                )
            ),
            arguments(
                ValidPalindromeIVTestData(
                    s = "aa",
                    expected = true,
                )
            ),
            arguments(
                ValidPalindromeIVTestData(
                    s = "abcdef",
                    expected = false,
                )
            ),
            arguments(
                ValidPalindromeIVTestData(
                    s = "a",
                    expected = true,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ValidPalindromeIVTestData) {
        val actual = ValidPalindromeIV().makePalindrome(data.s)

        assertEquals(data.expected, actual)
    }

    data class ValidPalindromeIVTestData(val s: String, val expected: Boolean)
}