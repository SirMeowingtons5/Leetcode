package easy

import utils.ListNode

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */

class ReversedLinkedList {

    fun reverseList(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current: ListNode? = head
        var next: ListNode? = current?.next

        while (current != null) {
            next = current.next
            current.next = previous

            previous = current
            current = next
        }

        return previous
    }
}