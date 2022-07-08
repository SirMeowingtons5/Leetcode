package easy

import utils.ListNode

/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * No tests because this problem is not worth it
 */

class DeleteNodeInLinkedList {

    fun deleteNode(node: ListNode?) {

        node?.`val` = node?.next?.`val`!!
        node.next = node.next?.next
    }
}