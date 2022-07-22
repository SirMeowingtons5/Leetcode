package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.TreeNode
import java.util.LinkedList
import java.util.Queue

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 102,
    title = "Binary Tree Level Order Traversal",
    link = "https://leetcode.com/problems/binary-tree-level-order-traversal/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class BinaryTreeLevelOrderTraversal {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val res = ArrayList<List<Int>>()

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelVals = ArrayList<Int>()
            val newLevelNodes = LinkedList<TreeNode>()

            queue.forEach { node ->
                levelVals.add(node.`val`)
                node.left?.let { newLevelNodes.add(it) }
                node.right?.let { newLevelNodes.add(it) }
            }
            res.add(levelVals)
            queue.clear()
            queue.addAll(newLevelNodes)
        }

        return res
    }
}