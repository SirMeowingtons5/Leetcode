package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import org.jetbrains.annotations.TestOnly
import utils.TreeNode
import java.util.*

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 101,
    title = "Symmetric Tree",
    link = "https://leetcode.com/problems/symmetric-tree/",
    difficulty = ProblemDifficulty.EASY,
)
class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean =
        isSymmetricRecursive(root?.left, root?.right)


    private fun isSymmetricRecursive(first: TreeNode?, second: TreeNode?): Boolean =
        when {
            first == null && second == null -> true
            first?.`val` != second?.`val` -> false
            else -> isSymmetricRecursive(first?.left, second?.right) && isSymmetricRecursive(first?.right, second?.left)
        }

    private fun isSymmetricIterative(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        queue.add(root)
        while (!queue.isEmpty()) {
            val t1 = queue.poll()
            val t2 = queue.poll()

            when {
                t1 == null && t2 == null -> continue
                t1?.`val` != t2?.`val` -> return false
                else -> queue.apply {
                    add(t1?.left)
                    add(t2?.right)
                    add(t1?.right)
                    add(t2?.left)
                }
            }
        }
        return true
    }

    @TestOnly
    fun testSymmetricRecursive(root: TreeNode?): Boolean =
        isSymmetricRecursive(root?.left, root?.right)

    @TestOnly
    fun testSymmetricIterative(root: TreeNode?): Boolean =
        isSymmetricIterative(root)
}