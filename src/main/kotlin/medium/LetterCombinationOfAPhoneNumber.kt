package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 17,
    title = "Letter Combinations of a Phone Number",
    link = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class LetterCombinationOfAPhoneNumber {

    fun letterCombinations(digits: String): List<String> {
        return if (digits.isEmpty()) emptyList() else combinations(digits)
    }

    private fun combinations(digits: String): List<String> =
        if (digits.isEmpty()) {
            listOf("")
        } else {
            dialer[digits.first()].orEmpty()
                .map { prefix ->
                    combinations(digits.substring(1))
                        .map { nextDigitsCombination -> prefix + nextDigitsCombination }
                }
                .flatten()
        }

    private val dialer = hashMapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z')
    )
}