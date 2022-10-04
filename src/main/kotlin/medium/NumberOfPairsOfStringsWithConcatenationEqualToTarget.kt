package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2023,
    title = "Number of Pairs of Strings With Concatenation Equal to Target",
    link = "https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    fun numOfPairs(nums: Array<String>, target: String): Int {
        val map = HashMap<String, Int>()
        nums.forEach { num ->
            map[num] = (map[num] ?: 0) + 1
        }

        var count = 0

        map.keys.forEach { num ->
            if (num + num == target) {
                count += map[num]!! * (map[num]!! - 1) // number of possible combinations = x * (x - 1)
            } else {
                val tail = target.removePrefix(num)
                count += map[num]!! * (map[tail] ?: 0)
            }
        }

        return count
    }
}