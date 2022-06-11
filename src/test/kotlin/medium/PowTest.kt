package medium

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PowTest {

    private companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(2.0, 10, 1024.0),
                arguments(2.1, 3, 9.261),
                arguments(2.0, -2, 0.25),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(x: Double, n: Int, expected: Double) {
        assertEquals(expected, Pow().myPow(x, n), 0.0001)
    }

    @Test
    fun `time limit test`() {
        assertEquals(0.0, Pow().myPow(2.0, -2147483648), 0.0001)
    }
}