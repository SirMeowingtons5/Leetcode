package easy

import org.junit.jupiter.api.Test
import utils.ListNode
import kotlin.test.assertEquals

class LinkedListCycleTest {

    @Test
    fun `contains cycle EXPECT true`() {
        val expected = true
        val rootNode = ListNode(1)
        var currentNode: ListNode = rootNode
        for (i in 2..5) {
            val newNode = ListNode(i)
            currentNode.next = newNode
            currentNode = newNode
        }
        currentNode.next =  rootNode.next

        val actual = LinkedListCycle().hasCycle(rootNode)

        assertEquals(expected, actual)
    }

    @Test
    fun `does not contain cycle EXPECT false`() {
        val expected = false
        val rootNode = ListNode(1)
        var currentNode: ListNode = rootNode
        for (i in 2..5) {
            val newNode = ListNode(i)
            currentNode.next = newNode
            currentNode = newNode
        }

        val actual = LinkedListCycle().hasCycle(rootNode)

        assertEquals(expected, actual)
    }
}