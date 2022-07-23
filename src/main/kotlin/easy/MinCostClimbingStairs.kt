package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 746,
    title = "Min Cost Climbing Stairs",
    link = "https://leetcode.com/problems/min-cost-climbing-stairs/",
    difficulty = ProblemDifficulty.EASY,
)
class MinCostClimbingStairs {

    fun minCostClimbingStairs(cost: IntArray): Int {
        val cache = HashMap<Int, Int>()

        return minOf(
            minCostWithCache(0, cost, cache),
            minCostWithCache(1, cost, cache)
        )
    }

    private fun minCostWithCache(n: Int, cost: IntArray, cache: HashMap<Int, Int>): Int {
        if (n >= cost.size) return 0
        if (cache.contains(n)) return requireNotNull(cache[n])

        val res = minOf(
            cost[n] + minCostWithCache(n + 1, cost, cache),
            cost[n] + minCostWithCache(n + 2, cost, cache)
        )
        cache[n] = res

        return res
    }
}