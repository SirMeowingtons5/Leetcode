package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LongestPalindromicSubstringTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(LongestPalindromicSubstringTestData(s = "babad", expected = "bab")),
            arguments(LongestPalindromicSubstringTestData(s = "cbbd", expected = "bb")),
            arguments(LongestPalindromicSubstringTestData(s = "bbcd", expected = "bb")),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: LongestPalindromicSubstringTestData) {
        val actual = LongestPalindromicSubstring().longestPalindrome(data.s)

        assertEquals(data.expected, actual)
    }

    data class LongestPalindromicSubstringTestData(val s: String, val expected: String)
}