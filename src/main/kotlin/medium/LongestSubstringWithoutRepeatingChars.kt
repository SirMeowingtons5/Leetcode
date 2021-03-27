package medium

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

class LongestSubstringWithoutRepeatingChars {

    fun lengthOfLongestSubstring(s: String): Int {
        val substring = StringBuilder()
        var maxStringLength = 0

        var startIndex = 0
        var currentIndex = startIndex
        var allCharsUnique = true

        val chars = s.toCharArray()

        while (startIndex < chars.size && currentIndex < chars.size) {
            currentIndex = startIndex
            allCharsUnique = true

            while (allCharsUnique && currentIndex < chars.size) {
                val char = chars[currentIndex]
                if (substring.contains(char)) {
                    startIndex += substring.indexOf(char) + 1
                    allCharsUnique = false
                    substring.clear()
                }else {
                    substring.append(char)
                }
                currentIndex++
                maxStringLength = maxOf(maxStringLength, substring.length)
            }
        }
        return maxStringLength
    }
}