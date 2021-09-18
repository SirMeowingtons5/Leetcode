package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.toInt
import utils.toListNode
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class ReversedLinkedListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(ReversedLinkedListTestData(head = intArrayOf(1,2,3,4,5).toListNode(), expected = intArrayOf(5,4,3,2,1).toListNode())),
            arguments(ReversedLinkedListTestData(head = intArrayOf(1,2).toListNode(), expected = intArrayOf(2,1).toListNode())),
            arguments(ReversedLinkedListTestData(head = intArrayOf(1).toListNode(), expected = intArrayOf(1).toListNode())),
            arguments(ReversedLinkedListTestData(head = null, expected = null))
        )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `sample data test`(data: ReversedLinkedListTestData) {
        val actual = ReversedLinkedList().reverseList(data.head)

        assertEquals(data.expected?.toInt(), actual?.toInt())
    }


    data class ReversedLinkedListTestData(val head: ListNode?, val expected: ListNode?)
}