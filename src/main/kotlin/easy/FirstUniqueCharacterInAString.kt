package easy

/**
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

class FirstUniqueCharacterInAString {

    fun firstUniqChar(s: String): Int {
        val uniqueChars = HashMap<Char, Boolean>()

        s.forEach { c -> uniqueChars[c] = !uniqueChars.contains(c) }

        s.forEachIndexed { index, c ->
            if (uniqueChars[c] == true) return index
        }

        return -1
    }
}