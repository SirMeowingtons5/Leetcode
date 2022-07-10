package utils

import java.util.*

fun treeNodesOf(vararg elements: Int?): TreeNode? {
    if (elements.isEmpty()) return null
    val head = TreeNode(elements.first()!!)
    var pointingLeft = true
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(head)

    for (i in 1 until elements.size) {
        val current = queue.peek()
        if (elements[i] != null) {
            val newNode = TreeNode(elements[i]!!)
            queue.add(newNode)
            if (pointingLeft) {
                current.left = newNode
            } else {
                current.right = newNode
            }
        }
        if (!pointingLeft) queue.remove() //we added node as right, so both left and right nodes are already assigned
        pointingLeft = !pointingLeft
    }

    return head
}