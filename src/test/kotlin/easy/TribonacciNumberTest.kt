package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class TribonacciNumberTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(TribonacciNumberTestData(n = 4, expected = 4)),
            arguments(TribonacciNumberTestData(n = 25, expected = 1389537)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: TribonacciNumberTestData) {
        val actual = TribonacciNumber().tribonacci(data.n)

        assertEquals(data.expected, actual)
    }

    data class TribonacciNumberTestData(val n: Int, val expected: Int)
}