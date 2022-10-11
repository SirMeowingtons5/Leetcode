package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty


@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2330,
    title = "Valid Palindrome IV",
    link = "https://leetcode.com/problems/valid-palindrome-iv/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class ValidPalindromeIV {

    fun makePalindrome(s: String): Boolean {
        var left = 0
        var right = 0

        if (s.length % 2 == 0) {
            right = s.length / 2
            left = right - 1
        } else {
            right = s.length / 2
            left = right
        }

        var differenceCount = 0

        while (left >= 0) {
            if (s[left] != s[right]) differenceCount++
            if (differenceCount > 2) return false

            left--
            right++
        }

        return true
    }
}