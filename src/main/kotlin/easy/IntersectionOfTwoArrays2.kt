package easy

/**
 * 350. Intersection of Two Arrays II
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */

class IntersectionOfTwoArrays2 {

    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        val map = HashMap<Int, Int>()
        val array: IntArray = if (nums1.size < nums2.size) {
            nums1.forEach {number ->
                if (map.contains(number)) {
                    map[number] = map[number]!! + 1
                } else {
                    map[number] = 1
                }
            }

            nums2
        } else {
            nums2.forEach {number ->
                if (map.contains(number)) {
                    map[number] = map[number]!! + 1
                } else {
                    map[number] = 1
                }
            }

            nums1
        }

        val res = ArrayList<Int>()

        array.forEach { number ->
            if (map.contains(number)) {
                res.add(number)

                if (map[number]!! > 1) {
                    map[number] = map[number]!! - 1
                } else {
                    map.remove(number)
                }
            }
        }

        return res.toIntArray()
    }
}