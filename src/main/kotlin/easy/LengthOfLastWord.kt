package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 58,
    title = "Length of Last Word",
    link = "https://leetcode.com/problems/length-of-last-word/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        var endIndex = s.length - 1

        while(s[endIndex] == ' ') {
            endIndex--
        }

        var startIndex = endIndex

        while (s[startIndex] != ' ' && startIndex != 0) {
            startIndex--
        }

        return endIndex - startIndex
    }
}