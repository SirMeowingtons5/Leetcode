package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import utils.toIntArray
import java.util.stream.Stream

class MergeNodesInBetweenZerosTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                MergeNodesInBetweenZerosTestData(
                    head = listNodeOf(0, 3, 1, 0, 4, 5, 2, 0),
                    expected = intArrayOf(4, 11),
                )
            ),
            arguments(
                MergeNodesInBetweenZerosTestData(
                    head = listNodeOf(0, 1, 0, 3, 0, 2, 2, 0),
                    expected = intArrayOf(1, 3, 4),
                )
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: MergeNodesInBetweenZerosTestData) {
        val actual = MergeNodesInBetweenZeros().mergeNodes(data.head).toIntArray()

        assertArrayEquals(data.expected, actual)
    }

    data class MergeNodesInBetweenZerosTestData(val head: ListNode?, val expected: IntArray)
}