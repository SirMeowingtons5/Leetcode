package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class LongestSubstringWithoutRepeatingCharsTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments("abcabcbb", 3),
                arguments("bbbbb", 1),
                arguments("pwwkew", 3),
                arguments("", 0),
                arguments(" ", 1),
                arguments("dvdf", 3)
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(s: String, expected: Int) {
        assertEquals(expected, LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring(s))
    }
}