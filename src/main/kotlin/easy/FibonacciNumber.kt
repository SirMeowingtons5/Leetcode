package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 509,
    title = "Fibonacci Number",
    link = "https://leetcode.com/problems/fibonacci-number/",
    difficulty = ProblemDifficulty.EASY,
)
class FibonacciNumber {

    fun fib(n: Int): Int {
        val cache = HashMap<Int, Int>().apply {
            put(0, 0)
            put(1, 1)
        }
        return fibWithCache(n, cache)
    }

    private fun fibWithCache(n: Int, cache: HashMap<Int, Int>): Int {
        if (cache.contains(n)) return requireNotNull(cache[n])

        val first = cache[n - 1] ?: fibWithCache(n - 1, cache)
        val second = cache[n - 2] ?: fibWithCache(n - 2, cache)
        val res = first + second
        cache[n] = res

        return res
    }
}