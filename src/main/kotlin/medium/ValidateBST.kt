package medium

import utils.TreeNode
import java.util.*

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 */

class ValidateBST {

    fun isValidBST(root: TreeNode?): Boolean {
        var current: TreeNode? = root ?: return true
        val stack: Stack<TreeNode> = Stack()
        var previous: TreeNode? = null

        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            if (previous != null && current.`val` <= previous.`val`) return false
            previous = current
            current = current.right
        }
        return true
    }
}