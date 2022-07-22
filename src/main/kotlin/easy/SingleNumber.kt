package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 136,
    title = "Single Number",
    link = "https://leetcode.com/problems/single-number/",
    difficulty = ProblemDifficulty.EASY,
)
class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        var res = 0

        nums.forEach {number ->
            res = res.xor(number)
        }

        return res
    }
}