package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class FibonacciNumberTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(FibonacciNumberTestData(n = 2, expected = 1)),
            arguments(FibonacciNumberTestData(n = 3, expected = 2)),
            arguments(FibonacciNumberTestData(n = 4, expected = 3)),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FibonacciNumberTestData) {
        val actual = FibonacciNumber().fib(data.n)

        assertEquals(data.expected, actual)
    }

    data class FibonacciNumberTestData(val n: Int, val expected: Int)
}