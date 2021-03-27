package medium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.math.pow
import kotlin.test.assertEquals

internal class AddTwoNumbersTest {

    companion object {

        @JvmStatic
        fun sampleData(): Stream<Arguments> =
            Stream.of(
                arguments(intArrayOf(2, 4, 3), intArrayOf(5, 6, 4), 807),
                arguments(intArrayOf(0), intArrayOf(0), 0),
                arguments(intArrayOf(9, 9, 9, 9, 9, 9, 9), intArrayOf(9, 9, 9, 9), 10009998)
            )
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    fun `example 1`(l1: IntArray, l2: IntArray, expected: Int) {
        val actual = AddTwoNumbers().addTwoNumbers(l1.toListNode(), l2.toListNode()).toInt()

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