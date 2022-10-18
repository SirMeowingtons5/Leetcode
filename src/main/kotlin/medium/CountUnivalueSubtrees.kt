package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.TreeNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 250,
    title = "Count Univalue Subtrees",
    link = "https://leetcode.com/problems/count-univalue-subtrees/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class CountUnivalueSubtrees {

    private var count = 0

    fun countUnivalSubtrees(root: TreeNode?): Int {
        count = 0
        isValidPart(root, 0)
        return count
    }

    private fun isValidPart(node: TreeNode?, parentValue: Int): Boolean {
        if (node == null) return true

        val leftValid = isValidPart(node.left, node.`val`)
        val rightValid = isValidPart(node.right, node.`val`)
        if (!(leftValid && rightValid)) return false

        count++

        return node.`val` == parentValue
    }
}