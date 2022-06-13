package easy

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
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