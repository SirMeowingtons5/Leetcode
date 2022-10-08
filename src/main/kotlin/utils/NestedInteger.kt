package utils

class NestedInteger {

    private var _integer: Int? = null

    private var _nestedList: MutableList<NestedInteger>? = null

    // Constructor initializes an empty nested list.
    constructor() {
        _nestedList = ArrayList()
    }

    // Constructor initializes a single integer.
    constructor(value: Int) {
        _integer = value
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = _integer != null

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? = _integer

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int) {
        _nestedList = null
        _integer = value
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger) {
        if (_nestedList == null) {
            _nestedList = ArrayList()
            _integer = null
        }
        _nestedList?.add(ni)
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? = _nestedList
}
