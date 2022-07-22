package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 387,
    title = "First Unique Character in a String",
    link = "https://leetcode.com/problems/first-unique-character-in-a-string/",
    difficulty = ProblemDifficulty.EASY,
)
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