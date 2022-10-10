package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1347,
    title = "Minimum Number of Steps to Make Two Strings Anagram",
    link = "https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    fun minSteps(s: String, t: String): Int {
        val chars = HashMap<Char, Int>()

        s.forEach {char ->
            chars[char] = (chars[char] ?: 0) + 1
        }

        t.forEach { char ->
            if (chars.contains(char)) {
                chars[char] = (chars[char] ?: 0) - 1
                if (chars[char] == 0) {
                    chars.remove(char)
                }
            }
        }

        return chars.values.sum()
    }
}