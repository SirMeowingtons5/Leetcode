package easy

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import utils.toInt
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class ReversedLinkedListTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> = Stream.of(
            arguments(ReversedLinkedListTestData(head = listNodeOf(1,2,3,4,5), expected = listNodeOf(5,4,3,2,1))),
            arguments(ReversedLinkedListTestData(head = listNodeOf(1,2), expected = listNodeOf(2,1))),
            arguments(ReversedLinkedListTestData(head = listNodeOf(1), expected = listNodeOf(1))),
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