package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import org.jetbrains.annotations.TestOnly
import utils.TreeNode
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 104,
    title = "Maximum Depth of Binary Tree",
    link = "https://leetcode.com/problems/maximum-depth-of-binary-tree/",
    difficulty = ProblemDifficulty.EASY,
)
class MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int =
        maxDepthIterative(root)

    private fun maxDepthIterative(root: TreeNode?): Int {
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

    var topBottomRes = 0
    private fun maxDepthRecursiveTopBottom(root: TreeNode?, depth: Int) {
        if (root == null) return

        if (root.left == null && root.right == null) {
            topBottomRes = maxOf(topBottomRes, depth)
        }

        maxDepthRecursiveTopBottom(root.left, depth + 1)
        maxDepthRecursiveTopBottom(root.right, depth + 1)
    }

    private fun maxDepthRecursiveBottomTop(root: TreeNode?): Int {
        if (root == null) return 0

        return maxOf(maxDepthRecursiveBottomTop(root.left), maxDepthRecursiveBottomTop(root.right)) + 1
    }

    @TestOnly
    fun testIterative(root: TreeNode?): Int =
        maxDepthIterative(root)

    @TestOnly
    fun testRecursiveBottomTop(root: TreeNode?): Int =
        maxDepthRecursiveBottomTop(root)

    @TestOnly
    fun testRecursiveTopBottom(root: TreeNode?): Int {
        topBottomRes = 0
        maxDepthRecursiveTopBottom(root, 1)
        return topBottomRes
    }
}