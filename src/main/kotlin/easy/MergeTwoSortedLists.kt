package easy

import utils.ListNode

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
class MergeTwoSortedLists {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val rootNode = ListNode(0)
        var current: ListNode? = rootNode
        var first = list1
        var second = list2

        while (first != null && second != null) {
            if (first.`val` < second.`val`) {
                current?.next = first
                first = first.next
            } else {
                current?.next = second
                second = second.next
            }

            current = current?.next
        }

        (first ?: second)?.let { leftNodes ->
            var currentLeft: ListNode? = leftNodes

            while (currentLeft != null) {
                current?.next = currentLeft
                current = current?.next
                currentLeft = currentLeft.next
            }
        }

        return rootNode.next
    }
}