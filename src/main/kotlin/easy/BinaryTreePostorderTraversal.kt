package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import org.jetbrains.annotations.TestOnly
import utils.TreeNode
import java.util.*
import kotlin.collections.ArrayList

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 145,
    title = "Binary Tree Postorder Traversal",
    link = "https://leetcode.com/problems/binary-tree-postorder-traversal/",
    difficulty = ProblemDifficulty.EASY,
)
class BinaryTreePostorderTraversal {

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val res = ArrayList<Int>()

        recursivePostorderTraversal(res, root)

        return res
    }

    private fun recursivePostorderTraversal(visited: MutableList<Int>, node: TreeNode?) {
        if (node == null) return

        recursivePostorderTraversal(visited, node.left)
        recursivePostorderTraversal(visited, node.right)
        visited.add(node.`val`)
    }

    private fun iterativePostorderTraversal(node: TreeNode?): List<Int> {
        if (node == null) return emptyList()
        val res = LinkedList<Int>()
        val stack = Stack<TreeNode>()
        stack.add(node)

        while (stack.isNotEmpty()) {
            val current = stack.pop()
            res.addFirst(current.`val`)
            current.left?.let { stack.add(it) }
            current.right?.let { stack.add(it) }
        }

        return res
    }

    @TestOnly
    fun testRecursive(root: TreeNode?): List<Int> =
        java.util.ArrayList<Int>().apply { recursivePostorderTraversal(this, root) }

    @TestOnly
    fun testIterative(root: TreeNode?): List<Int> =
        iterativePostorderTraversal(root)
}