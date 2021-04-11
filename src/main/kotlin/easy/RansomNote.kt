package easy

/**
 * https://leetcode.com/problems/ransom-note/
 */

class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val ransomChars = ransomNote.groupBy { it }
        val magazineChars = magazine.groupBy { it }

        ransomChars.forEach { (char, charList) ->
            val magazineCharCount = magazineChars[char]?.count()
            when {
                magazineCharCount == null -> return false
                magazineCharCount < charList.count() -> return false
            }
        }

        return true
    }

    fun secondVersion(ransomNote: String, magazine: String): Boolean {
        val noteCharsHashMap = HashMap<Char, Int>()
        val magazineCharsHashMap = HashMap<Char, Int>()

        ransomNote.forEach { char ->
            noteCharsHashMap[char]?.let { charCount ->
                noteCharsHashMap[char] = charCount + 1
            } ?: noteCharsHashMap.set(char, 1)
        }

        magazine.forEach { char ->
            if (noteCharsHashMap.containsKey(char)) {
                magazineCharsHashMap[char]?.let { charCount ->
                    magazineCharsHashMap[char] = charCount + 1
                } ?: magazineCharsHashMap.set(char, 1)
            }
        }

        noteCharsHashMap.forEach { (char, noteCount) ->
            val magazineCount = magazineCharsHashMap[char]
            when {
                magazineCount == null -> return false
                noteCount > magazineCount -> return false
            }
        }

        return true
    }
}