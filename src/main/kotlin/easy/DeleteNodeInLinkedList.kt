package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

/**
 * No tests because this problem is not worth it
 */

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 237,
    title = "Delete Node in a Linked List",
    link = "https://leetcode.com/problems/delete-node-in-a-linked-list/",
    difficulty = ProblemDifficulty.EASY,
)
class DeleteNodeInLinkedList {

    fun deleteNode(node: ListNode?) {

        node?.`val` = node?.next?.`val`!!
        node.next = node.next?.next
    }
}