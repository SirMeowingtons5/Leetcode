package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 5,
    title = "Longest Palindromic Substring",
    link = "https://leetcode.com/problems/longest-palindromic-substring/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        var longestSubstringIndices = Pair(0, 0)

        for (i in s.indices) {
            //Palindrome center at symbol
            var left = i
            var right = i
            while (left > 0 && right < s.length - 1 && s[left - 1] == s[right + 1]) {
                left--
                right++
            }

            if ((right - left) > (longestSubstringIndices.second - longestSubstringIndices.first)) {
                longestSubstringIndices = Pair(left, right)
            }

            if (i != s.length - 1 && s[i] == s[i + 1]) { // if not last symbol and next symbol equals current, check if palindrome with center between this and next
                left = i
                right = i + 1
                while (left > 0 && right < s.length - 1 && s[left - 1] == s[right + 1]) {
                    left--
                    right++
                }
                if ((right - left) > (longestSubstringIndices.second - longestSubstringIndices.first)) {
                    longestSubstringIndices = Pair(left, right)
                }
            }
        }

        return s.substring(longestSubstringIndices.first, longestSubstringIndices.second + 1)
    }
}