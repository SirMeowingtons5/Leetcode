package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import kotlin.collections.HashMap
import kotlin.collections.HashSet

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 15,
    title = "3Sum",
    link = "https://leetcode.com/problems/3sum/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = HashSet<List<Int>>()
        val duplicates = HashSet<Int>()
        val seen = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (duplicates.add(nums[i])) {
                for (j in i + 1 until nums.size) {
                    val thirdItem = -nums[i] - nums[j]
                    if (seen.containsKey(thirdItem) && seen[thirdItem] == i) {
                        val triplet: List<Int> = listOf(nums[i], nums[j], thirdItem)
                        res.add(triplet.sorted())
                    }
                    seen[nums[j]] = i
                }
            }
        }
        return res.toList()
    }
}