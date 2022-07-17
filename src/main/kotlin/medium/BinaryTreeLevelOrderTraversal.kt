package medium

import utils.TreeNode
import java.util.LinkedList
import java.util.Queue

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */

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