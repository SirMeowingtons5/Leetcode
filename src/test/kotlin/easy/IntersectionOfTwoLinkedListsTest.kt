package easy

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import utils.ListNode
import utils.listNodeOf
import java.util.stream.Stream
import kotlin.test.assertEquals

class IntersectionOfTwoLinkedListsTest {

    @Test
    fun `sample data test`() {
        val a: ListNode = listNodeOf(1, 2)!!
        val b: ListNode = listNodeOf(1, 2, 3)!!
        val c: ListNode = listNodeOf(1, 2, 3)!!
        val expected = c

        a.next?.next = c
        b.next?.next?.next = c

        val actual = IntersectionOfTwoLinkedLists().getIntersectionNode(a, b)

        assertEquals(expected, actual)
    }
}