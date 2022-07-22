package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 217,
    title = "Contains Duplicate",
    link = "https://leetcode.com/problems/contains-duplicate/",
    difficulty = ProblemDifficulty.EASY,
)
class ContainsDuplicate {

    fun containsDuplicate(nums: IntArray): Boolean {

        val set = HashSet<Int>()

        nums.forEach {number ->
            if (set.contains(number)) return true
            set.add(number)
        }

        return false
    }
}