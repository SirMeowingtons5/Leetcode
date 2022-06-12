package easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ReverseStringTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(
                    ReverseStringTestData(
                        s = charArrayOf('h', 'e', 'l', 'l', 'o'),
                        expected = charArrayOf('o', 'l', 'l', 'e', 'h'),
                    )
                ),
                arguments(
                    ReverseStringTestData(
                        s = charArrayOf('H', 'a', 'n', 'n', 'a', 'h'),
                        expected = charArrayOf('h', 'a', 'n', 'n', 'a', 'H'),
                    )
                )
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ReverseStringTestData) {
        ReverseString().reverseString(data.s)

        assertArrayEquals(data.expected, data.s)
    }

    data class ReverseStringTestData(
        val s: CharArray,
        val expected: CharArray,
    )
}