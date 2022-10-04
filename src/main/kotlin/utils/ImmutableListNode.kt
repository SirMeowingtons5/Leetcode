package utils

import org.jetbrains.annotations.TestOnly

class ImmutableListNode(private val value: Int) {

    private var next: ImmutableListNode? = null

    fun getNext(): ImmutableListNode? = next
    fun printValue() {
        log.add(value.toString())
    }

    @TestOnly
    fun setNext(node: ImmutableListNode?) {
        next = node
    }

    companion object {

        val log = ArrayList<String>()
    }
}