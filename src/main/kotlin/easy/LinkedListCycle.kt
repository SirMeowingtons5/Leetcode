package easy

import utils.ListNode

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */

class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        val set = HashSet<ListNode>()
        var current = head

        while (current != null) {
            if (set.contains(current)) {
                return true
            }
            set.add(current)
            current = current.next
        }

        return false
    }
}