package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MinimumNumberOfStepsToMakeTwoStringsAnagramTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MinimumNumberOfStepsToMakeTwoStringsAnagramTestData(
                    s = "bab",
                    t = "aba",
                    expected = 1
                )
            ),
            arguments(
                MinimumNumberOfStepsToMakeTwoStringsAnagramTestData(
                    s = "leetcode",
                    t = "practice",
                    expected = 5
                )
            ),
            arguments(
                MinimumNumberOfStepsToMakeTwoStringsAnagramTestData(
                    s = "anagram",
                    t = "mangaar",
                    expected = 5
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MinimumNumberOfStepsToMakeTwoStringsAnagramTestData) {
        val actual = MinimumNumberOfStepsToMakeTwoStringsAnagram().minSteps(data.s, data.t)

        assertEquals(data.expected, actual)
    }

    data class MinimumNumberOfStepsToMakeTwoStringsAnagramTestData(val s: String, val t: String, val expected: Int)
}