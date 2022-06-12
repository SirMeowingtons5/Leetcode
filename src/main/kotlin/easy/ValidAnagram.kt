package easy

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */
class ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        val letters = HashMap<Char, Int>()
        s.forEach { c -> letters[c] = if (letters.contains(c)) letters[c]!! + 1 else 1 }

        t.forEach { c ->
            if (letters.contains(c)) {
                letters[c] = letters[c]!! - 1
                if (letters[c] == 0) letters.remove(c)
            } else {
                return false
            }
        }

        return letters.isEmpty()
    }
}