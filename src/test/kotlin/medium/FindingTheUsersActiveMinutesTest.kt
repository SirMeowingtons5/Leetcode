package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class FindingTheUsersActiveMinutesTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                FindingTheUsersActiveMinutesTestData(
                    logs = arrayOf(
                        intArrayOf(0, 5),
                        intArrayOf(1, 2),
                        intArrayOf(0, 2),
                        intArrayOf(0, 5),
                        intArrayOf(1, 3)
                    ),
                    k = 5,
                    expected = intArrayOf(0, 2, 0, 0, 0),
                )
            ),
            arguments(
                FindingTheUsersActiveMinutesTestData(
                    logs = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(2, 3)),
                    k = 4,
                    intArrayOf(1, 1, 0, 0)
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FindingTheUsersActiveMinutesTestData) {
        val actual = FindingTheUsersActiveMinutes().findingUsersActiveMinutes(data.logs, data.k)

        assertArrayEquals(data.expected, actual)
    }

    data class FindingTheUsersActiveMinutesTestData(val logs: Array<IntArray>, val k: Int, val expected: IntArray)
}