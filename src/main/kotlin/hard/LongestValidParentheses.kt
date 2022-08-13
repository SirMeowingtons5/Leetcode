package hard

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import java.util.*

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 32,
    title = "Longest Valid Parentheses",
    link = "https://leetcode.com/problems/longest-valid-parentheses/",
    difficulty = ProblemDifficulty.HARD,
)
class LongestValidParentheses {

    fun longestValidParentheses(s: String): Int {
        val stack = Stack<Int>()
        var max = 0

        s.forEachIndexed { index, char ->
            when {
                char == '(' -> stack.push(index)
                char == ')' && stack.isEmpty() -> stack.push(index)
                char == ')' && s[stack.peek()] == '(' -> {
                    stack.pop()
                    val lastInvalidIndex = stack.lastOrNull() ?: -1 //-1 cause we need to count zero-index brace as well
                    max = maxOf(max, index - lastInvalidIndex)
                }
                char == ')' -> stack.push(index)
            }
        }

        return max
    }
}