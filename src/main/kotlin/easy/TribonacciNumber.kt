package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1137,
    title = "N-th Tribonacci Number",
    link = "https://leetcode.com/problems/n-th-tribonacci-number/",
    difficulty = ProblemDifficulty.EASY,
)
class TribonacciNumber {

    fun tribonacci(n: Int): Int {
        val cache = HashMap<Int, Int>().apply {
            put(0, 0)
            put(1, 1)
            put(2, 1)
        }

        return tribonacciWithCache(n, cache)
    }

    private fun tribonacciWithCache(n: Int, cache: HashMap<Int, Int>): Int =
        cache[n] ?: (tribonacciWithCache(n - 1, cache)
                + tribonacciWithCache(n - 2, cache)
                + tribonacciWithCache(n - 3, cache)).apply {
            cache[n] = this
        }
}