package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 921,
    title = "Minimum Operations to Make Array Equal",
    link = "https://leetcode.com/problems/minimum-operations-to-make-array-equal/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class MinimumOperationsToMakeArrayEqual {

    fun minOperations(n: Int): Int =
        if (n % 2 == 0) n * n / 4 else (n * n - 1) / 4
}