package easy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RansomNoteTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments("a", "b", false),
                arguments("aa", "ab", false),
                arguments("aa", "aab", true),
                arguments("abc", "bcabcb", true),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(note: String, magazine: String, expected: Boolean) {
        assertEquals(expected, RansomNote().canConstruct(note, magazine))
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `second version test`(note: String, magazine: String, expected: Boolean) {
        assertEquals(expected, RansomNote().secondVersion(note, magazine))
    }
}