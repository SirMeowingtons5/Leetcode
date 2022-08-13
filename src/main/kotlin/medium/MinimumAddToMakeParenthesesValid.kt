package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import java.util.Stack

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 921,
    title = "Minimum Add to Make Parentheses Valid",
    link = "https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class MinimumAddToMakeParenthesesValid {

    fun minAddToMakeValid(s: String): Int {
        val stack = Stack<Char>()
        var res = 0

        s.forEach {
            if (it == '(') {
                stack.add(it)
            } else {
                if (stack.isNotEmpty()) {
                    stack.pop()
                } else {
                    res++
                }
            }
        }

        return res + stack.count()
    }
}