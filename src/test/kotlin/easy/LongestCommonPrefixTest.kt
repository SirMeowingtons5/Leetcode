package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LongestCommonPrefixTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(LongestCommonPrefixTestData(strs = arrayOf("flower","flow","flight"), expected = "fl")),
            arguments(LongestCommonPrefixTestData(strs = arrayOf("dog","racecar","car"), expected = "")),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: LongestCommonPrefixTestData) {
        val actual = LongestCommonPrefix().longestCommonPrefix(data.strs)

        assertEquals(data.expected, actual)
    }

    data class LongestCommonPrefixTestData(val strs: Array<String>, val expected: String,)
}