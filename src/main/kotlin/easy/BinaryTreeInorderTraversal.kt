package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import org.jetbrains.annotations.TestOnly
import utils.TreeNode
import java.util.*

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 94,
    title = "Binary Tree Inorder Traversal",
    link = "https://leetcode.com/problems/binary-tree-inorder-traversal/",
    difficulty = ProblemDifficulty.EASY,
)
class BinaryTreeInorderTraversal {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()

        recursiveInorderTraversal(res, root)

        return res
    }

    private fun recursiveInorderTraversal(visited: MutableList<Int>, node: TreeNode?) {
        if (node == null) return

        recursiveInorderTraversal(visited, node.left)
        visited.add(node.`val`)
        recursiveInorderTraversal(visited, node.right)
    }

    private fun iterativeInorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()
        val stack = Stack<TreeNode>()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            res.add(current.`val`)
            current = current.right
        }
        return res
    }

    @TestOnly
    fun testRecursive(root: TreeNode?): List<Int> =
        ArrayList<Int>().apply { recursiveInorderTraversal(this, root) }

    @TestOnly
    fun testIterative(root: TreeNode?): List<Int> =
        iterativeInorderTraversal(root)
}