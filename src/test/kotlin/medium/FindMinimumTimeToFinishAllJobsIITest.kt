package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class FindMinimumTimeToFinishAllJobsIITest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                FindMinimumTimeToFinishAllJobsIITestData(
                    jobs = intArrayOf(5, 2, 4),
                    workers = intArrayOf(1, 7, 5),
                    expected = 2,
                )
            ),
            arguments(
                FindMinimumTimeToFinishAllJobsIITestData(
                    jobs = intArrayOf(3,18,15,9),
                    workers = intArrayOf(6,5,1,3),
                    expected = 3,
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: FindMinimumTimeToFinishAllJobsIITestData) {
        val actual = FindMinimumTimeToFinishAllJobsII().minimumTime(data.jobs, data.workers)

        assertEquals(data.expected, actual)
    }

    data class FindMinimumTimeToFinishAllJobsIITestData(val jobs: IntArray, val workers: IntArray, val expected: Int)
}