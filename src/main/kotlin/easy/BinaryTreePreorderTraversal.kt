package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import org.jetbrains.annotations.TestOnly
import utils.TreeNode
import java.util.*

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 144,
    title = "Binary Tree Preorder Traversal",
    link = "https://leetcode.com/problems/binary-tree-preorder-traversal/",
    difficulty = ProblemDifficulty.EASY,
)
class BinaryTreePreorderTraversal {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()

        recursivePreorderTraversal(res, root)
        return res
    }

    private fun recursivePreorderTraversal(visited: MutableList<Int>, root: TreeNode?) {
        if (root == null) return

        visited.add(root.`val`)
        recursivePreorderTraversal(visited, root.left)
        recursivePreorderTraversal(visited, root.right)
    }

    private fun iterativePreorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val stack = Stack<TreeNode>()
        val res = ArrayList<Int>()

        stack.add(root)

        while(stack.isNotEmpty()) {
            val node = stack.pop()
            res.add(node.`val`)
            node.right?.let { stack.add(it) }
            node.left?.let { stack.add(it) }
        }

        return res
    }

    @TestOnly
    fun testRecursive(root: TreeNode?): List<Int> =
        ArrayList<Int>().apply { recursivePreorderTraversal(this, root) }

    @TestOnly
    fun testIterative(root: TreeNode?): List<Int> =
        iterativePreorderTraversal(root)
}