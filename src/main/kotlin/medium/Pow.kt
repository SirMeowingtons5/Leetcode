package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 50,
    title = "Pow(x, n)",
    link = "https://leetcode.com/problems/powx-n/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class Pow {

    fun myPow(x: Double, n: Int): Double {
        var powerAbs: Long = Math.abs(n.toLong())
        var base = x

        var res = 1.0

        while (powerAbs > 0) {
            val isOdd = (powerAbs and 1) == 1L
            if (isOdd) res *= base

            powerAbs /= 2
            base *= base
        }

        return if (n >= 0) res else (1 / res)
    }
}