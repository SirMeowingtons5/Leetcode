package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 344,
    title = "Reverse String",
    link = "https://leetcode.com/problems/reverse-string/",
    difficulty = ProblemDifficulty.EASY,
)
class ReverseString {

    fun reverseString(s: CharArray) {
        var left = 0
        var right = s.size - 1

        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }
    }
}