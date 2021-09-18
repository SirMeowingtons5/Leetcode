package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class GuessNumberTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(GuessNumberTestData(n = 10, pick = 6)),
            arguments(GuessNumberTestData(n = 1, pick = 1)),
            arguments(GuessNumberTestData(n = 2, pick = 1)),
            arguments(GuessNumberTestData(n = 2, pick = 2)),
            arguments(GuessNumberTestData(n = 2126753390, pick = 1702766719))
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: GuessNumberTestData) {
        val actual = GuessNumber(data.pick).guessNumber(data.n)
        val expected = data.pick

        assertEquals(expected, actual)
    }

    data class GuessNumberTestData(val n: Int, val pick: Int)
}