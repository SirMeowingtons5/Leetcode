package medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.toIntArray
import utils.toListNode
import java.util.stream.Stream
import kotlin.test.assertEquals

class RemoveNthNodeFromEndOfListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(
                RemoveNthNodeFromEndOfListTestData(
                    head = intArrayOf(1, 2, 3, 4, 5).toListNode()!!,
                    n = 2,
                    expected = intArrayOf(1, 2, 3, 5).toListNode()!!,
                ),
            ),
            arguments(
                RemoveNthNodeFromEndOfListTestData(
                    head = intArrayOf(1, 2, 3, 4, 5).toListNode()!!,
                    n = 5,
                    expected = intArrayOf(2, 3, 4, 5).toListNode()!!,
                ),
            ),
            arguments(
                RemoveNthNodeFromEndOfListTestData(
                    head = intArrayOf(1, 2).toListNode()!!,
                    n = 1,
                    expected = intArrayOf(1).toListNode()!!,
                ),
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: RemoveNthNodeFromEndOfListTestData) {
        val actual = RemoveNthNodeFromEndOfList().removeNthFromEnd(data.head, data.n)?.toIntArray()
        val expected = data.expected.toIntArray()

        assertArrayEquals(expected, actual)
    }

    @Test
    fun `removing single node EXPECT null as result`() {
        val actual = RemoveNthNodeFromEndOfList().removeNthFromEnd(head = intArrayOf(1).toListNode()!!, n = 1)
        val expected: ListNode? = null

        assertEquals(expected, actual)
    }

    data class RemoveNthNodeFromEndOfListTestData(val head: ListNode, val n: Int, val expected: ListNode)
}