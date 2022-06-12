package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ValidAnagramTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(ValidAnagramTestData(s = "anagram", t = "nagaram", expected = true)),
            arguments(ValidAnagramTestData(s = "rat", t = "car", expected = false)),
            arguments(ValidAnagramTestData(s = "ab", t = "a", expected = false)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ValidAnagramTestData) {
        val actual = ValidAnagram().isAnagram(data.s, data.t)

        assertEquals(data.expected, actual)
    }

    data class ValidAnagramTestData(val s: String, val t: String, val expected: Boolean)
}