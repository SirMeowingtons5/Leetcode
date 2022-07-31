package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 160,
    title = "Intersection of Two Linked Lists",
    link = "https://leetcode.com/problems/intersection-of-two-linked-lists/",
    difficulty = ProblemDifficulty.EASY,
)
class IntersectionOfTwoLinkedLists {

    fun getIntersectionNode(headA:ListNode, headB:ListNode): ListNode? {
        val cache = HashSet<ListNode>()

        var aHead: ListNode? = headA
        var bHead: ListNode? = headB

        while (aHead != null) {
            cache.add(aHead)
            aHead = aHead.next
        }

        while(bHead != null) {
            if (cache.contains(bHead)) return bHead
            bHead = bHead.next
        }

        return null
    }
}