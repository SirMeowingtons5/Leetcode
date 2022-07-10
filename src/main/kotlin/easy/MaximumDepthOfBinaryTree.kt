package easy

import utils.TreeNode
import java.util.LinkedList
import java.util.Queue

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */

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