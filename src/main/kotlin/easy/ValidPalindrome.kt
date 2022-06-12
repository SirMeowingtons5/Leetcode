package easy

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            while (!s[left].isLetterOrDigit() && left < right) left++
            while (!s[right].isLetterOrDigit() && right > left) right--
            if (left < right) {
               if (s[left].toLowerCase() != s[right].toLowerCase()) return false
            }
            left++
            right--
        }

        return true
    }
}