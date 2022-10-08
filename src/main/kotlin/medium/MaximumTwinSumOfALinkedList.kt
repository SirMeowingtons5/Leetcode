package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2130,
    title = "Maximum Twin Sum of a Linked List",
    link = "https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class MaximumTwinSumOfALinkedList {

    private lateinit var leftNode: ListNode

    private var max = 0

    fun pairSum(head: ListNode): Int {
        leftNode = head

        findRecursivePairMaxSum(head)

        return max
    }

    private fun findRecursivePairMaxSum(current: ListNode) {
        current.next?.let { findRecursivePairMaxSum(it) }
        max = maxOf(max, current.`val` + leftNode.`val`)

        leftNode.next?.let { next ->
            leftNode = next
        }
    }
}