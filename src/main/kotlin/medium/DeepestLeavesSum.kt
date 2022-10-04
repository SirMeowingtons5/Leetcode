package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.TreeNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1302,
    title = "Deepest Leaves Sum",
    link = "https://leetcode.com/problems/deepest-leaves-sum/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class DeepestLeavesSum {

    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0

        val currentRow = ArrayList<TreeNode>()
        val nextRow = ArrayList<TreeNode>()

        currentRow.add(root)
        var lastRowFound = false
        while (!lastRowFound) {
            nextRow.clear()

            currentRow.forEach {
                if (it.left != null) {
                    nextRow.add(it.left!!)
                }
                if (it.right != null) {
                    nextRow.add(it.right!!)
                }
            }

            if (nextRow.isNotEmpty()) {
                currentRow.clear()
                currentRow.addAll(nextRow)
            } else {
                lastRowFound = true
            }
        }

        return currentRow.sumBy { it.`val` }
    }
}