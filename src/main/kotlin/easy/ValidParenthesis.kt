package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses
 */
@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 20,
    title = "Valid Parentheses",
    link = "https://leetcode.com/problems/valid-parentheses/",
    difficulty = ProblemDifficulty.EASY,
)
class ValidParenthesis {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val openBracket = listOf('(', '[', '{')

        s.forEach { char ->
            when {
                char in openBracket -> stack.push(char)
                stack.isNotEmpty() && bracketsMatch(open = stack.peek(), close = char) -> stack.pop()
                else -> return false
            }
        }

        return stack.isEmpty()
    }

    private fun bracketsMatch(open: Char, close: Char): Boolean =
        when {
            open == '(' && close == ')' -> true
            open == '[' && close == ']' -> true
            open == '{' && close == '}' -> true
            else -> false
        }
}