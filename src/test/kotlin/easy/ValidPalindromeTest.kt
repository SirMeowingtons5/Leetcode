package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ValidPalindromeTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(ValidPalindromeTestData(s = "A man, a plan, a canal: Panama", expected = true)),
            arguments(ValidPalindromeTestData(s = "race a car", expected = false)),
            arguments(ValidPalindromeTestData(s = " ", expected = true)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ValidPalindromeTestData) {
        val actual = ValidPalindrome().isPalindrome(data.s)

        assertEquals(data.expected, actual)
    }

    data class ValidPalindromeTestData(val s: String, val expected: Boolean)
}