package utils

fun listNodeOf(vararg elements: Int): ListNode? =
    if (elements.isEmpty()) {
        null
    } else {
        ListNode(elements[0]).apply {
            var currentNode = this
            for (i in 1 until elements.size) {
                val newNode = ListNode(elements[i])
                currentNode.next = newNode
                currentNode = newNode
            }
        }
    }

fun ListNode?.toIntArray(): IntArray {
    val res = ArrayList<Int>()

    var current: ListNode? = this

    while (current != null) {
        res.add(current.`val`)
        current = current.next
    }

    return res.toIntArray()
}