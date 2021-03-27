package medium

/**
 * https://leetcode.com/problems/add-two-numbers/
 */

/**
 * This class should not be implemented in solution, since leetcode has it's own implementation
 * Keep it for tests only
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        val resultRootNode = ListNode(Int.MIN_VALUE)

        var currentResNode = resultRootNode
        var currentFirstNode: ListNode? = l1
        var currentSecondNode: ListNode? = l2
        var shouldAddToNext = false

        while (currentFirstNode != null || currentSecondNode != null || shouldAddToNext) {
            val firstNodeValue: Int = currentFirstNode?.`val` ?: 0
            val secondNodeValue: Int = currentSecondNode?.`val` ?: 0
            var newNodeVal = firstNodeValue + secondNodeValue
            if (shouldAddToNext) {
                newNodeVal++
            }

            shouldAddToNext = newNodeVal >= 10
            newNodeVal %= 10

            val newNode = ListNode(newNodeVal)
            currentResNode.next = newNode

            currentFirstNode = currentFirstNode?.next
            currentSecondNode = currentSecondNode?.next
            currentResNode = newNode
        }

        return resultRootNode.next ?: throw Exception("Both nodes can't be empty")
    }
}