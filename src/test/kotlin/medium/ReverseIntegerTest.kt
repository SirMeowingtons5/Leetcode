package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class ReverseIntegerTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(ReverseIntegerTestData(x = 123, expected = 321)),
            arguments(ReverseIntegerTestData(x = -123, expected = -321)),
            arguments(ReverseIntegerTestData(x = 120, expected = 21)),
            arguments(ReverseIntegerTestData(x = 1463847413, expected = 0)),
            arguments(ReverseIntegerTestData(x = -1463847413, expected = 0)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ReverseIntegerTestData) {
        val actual = ReverseInteger().reverse(data.x)

        assertEquals(data.expected, actual)
    }

    data class ReverseIntegerTestData(val x: Int, val expected: Int)
}