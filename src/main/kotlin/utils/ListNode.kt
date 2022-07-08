package utils

import kotlin.math.pow

/**
 * This class should not be implemented in solution, since leetcode has it's own implementation
 * Keep it for tests only
 * DO NOT FORGET to remove import from your solution before submitting it
 */
class ListNode(var `val`: Int) {

    var next: ListNode? = null

    override fun equals(other: Any?): Boolean =
        other is ListNode
                && this.`val` == other.`val`
                && ((this.next == null && other.next == null) || (this.next?.equals(other.next) ?: false))

}

fun IntArray.toListNode(): ListNode? {
    if (this.isEmpty()) return null

    val rootNode = ListNode(this[0])
    var currentNode = rootNode

    for (i in 1 until this.size) {
        val newNode = ListNode(this[i])
        currentNode.next = newNode
        currentNode = newNode
    }

    return rootNode
}

fun ListNode?.toIntArray(): IntArray {
    val res = ArrayList<Int>()

    var current: ListNode? = this

    while (current != null) {
        res.add(current.`val`)
        current = current.next
    }

    return res.toIntArray()
}

fun ListNode.toInt(): Int {
    val sb = StringBuilder()

    var currentNode: ListNode? = this

    while (currentNode != null) {
        sb.append(currentNode.`val`)
        currentNode = currentNode.next
    }

    return sb.toString().toInt()
}

fun ListNode.toReversedInt(): Int {
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