package utils

fun immutableListNodesOf(vararg elements: Int): ImmutableListNode? {
    if (elements.isEmpty()) return null
    val head = ImmutableListNode(elements.first())

    var current: ImmutableListNode = head
    for (i in 1 until elements.size) {
        val newNode = ImmutableListNode(elements[i])
        current.setNext(newNode)
        current = newNode
    }

    return head
}