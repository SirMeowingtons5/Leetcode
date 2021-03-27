package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class ReverseIntegerTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(123, 321),
                arguments(-123, -321),
                arguments(120, 21),
                arguments(0, 0),
                arguments(2147483647, 0),
                arguments(-2147483648, 0)
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(x: Int, expected: Int) {
        assertEquals(expected, ReverseInteger().reverse(x))
    }

}