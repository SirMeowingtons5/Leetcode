package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 7,
    title = "Reverse Integer",
    link = "https://leetcode.com/problems/reverse-integer/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class ReverseInteger {

    fun reverse(x: Int): Int {
        var original = x
        var result = 0

        while (original != 0) {
            val temp = original % 10
            original /= 10
            if ((result >= 214_748_364 && temp > 7)
                || result > 214_748_364
                || (result <= -214_748_364 && temp < -8)
                || result < -214_748_364
            ) return 0

            result *= 10
            result += temp
        }

        return result
    }
}