package hard

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode
import java.util.PriorityQueue
import kotlin.Comparator

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 23,
    title = "Merge k Sorted Lists",
    link = "https://leetcode.com/problems/merge-k-sorted-lists/",
    difficulty = ProblemDifficulty.HARD,
)
class MergeKSortedList {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val comparator: Comparator<ListNode> = compareBy { it.`val` }
        val queue = PriorityQueue(comparator)
        val resRootNode = ListNode(Int.MAX_VALUE)
        lists.forEach { if (it != null) queue.add(it) }

        var currentNode = resRootNode

        while (queue.isNotEmpty()) {
            val smallestNode = queue.remove()
            currentNode.next = smallestNode
            currentNode = smallestNode

            val newNode = smallestNode.next
            if (newNode != null) {
                queue.add(newNode)
            }
        }
        return resRootNode.next
    }
}