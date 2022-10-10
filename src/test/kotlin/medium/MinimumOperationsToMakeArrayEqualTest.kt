package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MinimumOperationsToMakeArrayEqualTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MinimumOperationsToMakeArrayEqualTestData(
                    n = 3,
                    expected = 2,
                )
            ),
            arguments(
                MinimumOperationsToMakeArrayEqualTestData(
                    n = 6,
                    expected = 9,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MinimumOperationsToMakeArrayEqualTestData) {
        val actual = MinimumOperationsToMakeArrayEqual().minOperations(data.n)

        assertEquals(data.expected, actual)
    }

    data class MinimumOperationsToMakeArrayEqualTestData(val n: Int, val expected: Int)
}