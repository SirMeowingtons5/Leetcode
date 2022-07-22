package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 206,
    title = "Reverse Linked List",
    link = "https://leetcode.com/problems/reverse-linked-list/",
    difficulty = ProblemDifficulty.EASY,
)
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