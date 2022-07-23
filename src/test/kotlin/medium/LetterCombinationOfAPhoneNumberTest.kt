package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LetterCombinationOfAPhoneNumberTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                LetterCombinationOfAPhoneNumberTestData(
                    digits = "23",
                    expected = listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
                )
            ),
            arguments(LetterCombinationOfAPhoneNumberTestData(digits = "", expected = emptyList())),
            arguments(LetterCombinationOfAPhoneNumberTestData(digits = "2", expected = listOf("a", "b", "c")))
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: LetterCombinationOfAPhoneNumberTestData) {
        val actual = LetterCombinationOfAPhoneNumber().letterCombinations(data.digits)

        assertEquals(data.expected, actual)
    }

    data class LetterCombinationOfAPhoneNumberTestData(val digits: String, val expected: List<String>)
}