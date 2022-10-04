package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.ImmutableListNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1265,
    title = "Print Immutable Linked List in Reverse",
    link = "https://leetcode.com/problems/print-immutable-linked-list-in-reverse/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class PrintImmutableLinkedListInReverse {

    fun printLinkedListInReverse(head: ImmutableListNode?) {
        if (head == null) return

        printLinkedListInReverse(head.getNext())
        head.printValue()
    }
}