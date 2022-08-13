package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class LengthOfLastWordTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(LengthOfLastWordTestData(s = "Hello World", expected = 5)),
            arguments(LengthOfLastWordTestData(s = "   fly me   to   the moon  ", expected = 4)),
            arguments(LengthOfLastWordTestData(s = "luffy is still joyboy", expected = 6)),
            arguments(LengthOfLastWordTestData(s = "Today is a nice day", expected = 3)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: LengthOfLastWordTestData) {
        val actual = LengthOfLastWord().lengthOfLastWord(data.s)

        assertEquals(data.expected, actual)
    }

    data class LengthOfLastWordTestData(val s: String, val expected: Int)
}