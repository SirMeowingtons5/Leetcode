package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 14,
    title = "Longest Common Prefix",
    link = "https://leetcode.com/problems/longest-common-prefix/",
    difficulty = ProblemDifficulty.EASY,
)
class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        val res = StringBuilder()

        strs.first().forEachIndexed { index, c ->
            strs.forEach { str ->
                if (index >= str.length || str[index] != c) return res.toString()
            }
            res.append(c)
        }

        return res.toString()
    }
}