package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 19,
    title = "Remove Nth Node From End of List",
    link = "https://leetcode.com/problems/remove-nth-node-from-end-of-list/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class RemoveNthNodeFromEndOfList {

    fun removeNthFromEnd(head: ListNode, n: Int): ListNode? {

        val root = ListNode(0)
        root.next = head

        var slow: ListNode = root
        var fast: ListNode? = root

        for (i in 0 until n) {
            fast = fast?.next
        }

        while (fast?.next != null) {
            fast = fast.next!!
            slow = slow.next!!
        }

        slow.next = slow.next?.next

        return root.next
    }
}