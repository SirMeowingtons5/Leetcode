package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.NestedInteger

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 339,
    title = "Nested List Weight Sum",
    link = "https://leetcode.com/problems/nested-list-weight-sum/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class NestedListWeightSum {

    fun depthSum(nestedList: List<NestedInteger>): Int {
        val currentLayer = ArrayList<NestedInteger>(nestedList)
        var currentDepth = 1
        var sum = 0

        while (currentLayer.isNotEmpty()) {
            val nextLayer = ArrayList<NestedInteger>()

            currentLayer.forEach { nestedInteger ->
                if (nestedInteger.isInteger()) {
                    sum += nestedInteger.getInteger()!! * currentDepth
                } else {
                    nextLayer.addAll(nestedInteger.getList()!!)
                }
            }

            currentLayer.clear()
            currentLayer.addAll(nextLayer)
            currentDepth++
        }

        return sum
    }
}