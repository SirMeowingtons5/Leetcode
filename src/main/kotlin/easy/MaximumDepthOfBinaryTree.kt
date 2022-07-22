package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.TreeNode
import java.util.LinkedList
import java.util.Queue

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 104,
    title = "Maximum Depth of Binary Tree",
    link = "https://leetcode.com/problems/maximum-depth-of-binary-tree/",
    difficulty = ProblemDifficulty.EASY,
)
class MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var counter = 0

        while (queue.isNotEmpty()) {
            counter++
            val nextLayer: Queue<TreeNode> = LinkedList()

            queue.forEach {
                if (it.left != null) nextLayer.add(it.left)
                if (it.right != null) nextLayer.add(it.right)
            }
            queue.clear()
            queue.addAll(nextLayer)
        }

        return counter
    }
}