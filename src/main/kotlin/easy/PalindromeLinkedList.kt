package easy

import utils.ListNode

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */

class PalindromeLinkedList {

    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head

        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        if (fast != null) { //is odd
            slow = slow?.next
        }

        var firstHalfNode: ListNode? = head
        var reversedSecondHalfNode: ListNode? = slow?.let { reverse(it) }

        while (reversedSecondHalfNode != null) {
            if (firstHalfNode?.`val` != reversedSecondHalfNode.`val`) {
                return false
            }
            firstHalfNode = firstHalfNode.next
            reversedSecondHalfNode = reversedSecondHalfNode.next
        }

        return true
    }


    private fun reverse(head: ListNode?): ListNode? {
        var head = head
        var prev: ListNode? = null
        while (head != null) {
            val next = head.next
            head.next = prev
            prev = head
            head = next
        }
        return prev
    }
}