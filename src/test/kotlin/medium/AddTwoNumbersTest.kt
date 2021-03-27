package medium

import org.junit.Test
import kotlin.math.pow
import kotlin.test.assertEquals

internal class AddTwoNumbersTest {

    private val addTwoNumbers = AddTwoNumbers()

    @Test
    fun `example 1`() {
        val l1 = intArrayOf(2, 4, 3).toListNode()
        val l2 = intArrayOf(5, 6, 4).toListNode()
        val expected = 807
        val actual = addTwoNumbers.addTwoNumbers(l1, l2).toInt()

        assertEquals(expected, actual)
    }

    @Test
    fun `example 2`() {
        val l1 = intArrayOf(0).toListNode()
        val l2 = intArrayOf(0).toListNode()
        val expected = 0
        val actual = addTwoNumbers.addTwoNumbers(l1, l2).toInt()

        assertEquals(expected, actual)
    }

    @Test
    fun `example 3`() {
        val l1 = intArrayOf(9, 9, 9, 9, 9, 9, 9).toListNode()
        val l2 = intArrayOf(9, 9, 9, 9).toListNode()
        val expected = 10009998
        val actual = addTwoNumbers.addTwoNumbers(l1, l2).toInt()

        assertEquals(expected, actual)
    }


    private fun IntArray.toListNode(): ListNode {
        if (this.isEmpty()) return ListNode(0)

        val rootNode = ListNode(this[0])
        var currentNode = rootNode

        for (i in 1 until this.size) {
            val newNode = ListNode(this[i])
            currentNode.next = newNode
            currentNode = newNode
        }

        return rootNode
    }

    private fun ListNode.toInt(): Int {
        var result = 0
        var currentIndex = 0
        var currentNode: ListNode? = this

        while (currentNode != null) {
            result += currentNode.`val` * 10.0.pow(currentIndex).toInt()
            currentIndex++
            currentNode = currentNode.next
        }

        return result
    }
}