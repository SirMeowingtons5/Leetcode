package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2181,
    title = "Merge Nodes in Between Zeros",
    link = "https://leetcode.com/problems/merge-nodes-in-between-zeros/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class MergeNodesInBetweenZeros {

    fun mergeNodes(head: ListNode?): ListNode? {
        var lastZeroNode: ListNode? = head
        var sumFromLastZero = 0

        var current: ListNode? = head

        while (current?.next != null) {
            current = current.next
            sumFromLastZero += current?.`val` ?: 0

            if (current?.`val` == 0) {
                if(current.next != null) {
                    lastZeroNode?.next = current
                } else {
                    lastZeroNode?.next = null
                }
                lastZeroNode?.`val` = sumFromLastZero
                lastZeroNode = current
                sumFromLastZero = 0
            }
        }

        return head
    }
}