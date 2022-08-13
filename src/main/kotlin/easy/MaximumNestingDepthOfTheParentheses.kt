package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1614,
    title = "Maximum Nesting Depth of the Parentheses",
    link = "https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/",
    difficulty = ProblemDifficulty.EASY,
)
class MaximumNestingDepthOfTheParentheses {

    fun maxDepth(s: String): Int {
        var max = 0
        var current = 0

        s.forEach {
            when (it) {
                '(' -> {
                    current++
                    max = maxOf(max, current)
                }
                ')' -> {
                    current--
                }
                else -> Unit
            }
        }

        return max
    }
}