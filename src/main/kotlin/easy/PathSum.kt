package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.TreeNode

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 112,
    title = "Path Sum",
    link = "https://leetcode.com/problems/path-sum/",
    difficulty = ProblemDifficulty.EASY,
)
class PathSum {

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false

        return when {
            root.left == null && root.right == null && root.`val` == targetSum -> true
            else -> hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
        }
    }
}