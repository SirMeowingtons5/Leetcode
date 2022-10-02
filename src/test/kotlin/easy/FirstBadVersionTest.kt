package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class FirstBadVersionTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(FirstBadVersionTestData(n = 5, bad = 4)),
            arguments(FirstBadVersionTestData(n = 1, bad = 1)),
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FirstBadVersionTestData) {
        val actual = FirstBadVersion(bad = data.bad).firstBadVersion(data.n)

        assertEquals(data.bad, actual)
    }

    data class FirstBadVersionTestData(val n: Int, val bad: Int)
}