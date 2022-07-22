package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 141,
    title = "Linked List Cycle",
    link = "https://leetcode.com/problems/linked-list-cycle/",
    difficulty = ProblemDifficulty.EASY,
)
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