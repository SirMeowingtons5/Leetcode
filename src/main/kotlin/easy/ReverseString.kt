package easy

/**
 * 344. Reverse String
 * https://leetcode.com/problems/reverse-string/
 */

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