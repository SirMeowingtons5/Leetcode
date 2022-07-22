package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 198,
    title = "House Robber",
    link = "https://leetcode.com/problems/house-robber/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class HouseRobber {

    fun rob(nums: IntArray): Int {
        val cache = HashMap<Int, Int>()

        return maxOf(
            robWithCache(0, nums, cache),
            robWithCache(1, nums, cache)
        )
    }

    private fun robWithCache(n: Int, nums: IntArray, cache: HashMap<Int, Int>): Int {
        if (n >= nums.size) return 0
        if (cache[n] != null) return requireNotNull(cache[n])

        val res = maxOf(
            nums[n] + robWithCache(n + 2, nums, cache),
            robWithCache(n + 1, nums, cache)
        )
        cache[n] = res

        return res
    }
}