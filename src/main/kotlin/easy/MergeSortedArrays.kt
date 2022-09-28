package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 88,
    title = "Merge Sorted Array",
    link = "https://leetcode.com/problems/merge-sorted-array/",
    difficulty = ProblemDifficulty.EASY,
)
class MergeSortedArrays {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        for (i in nums1.size - 1 downTo n) {
            nums1[i] = nums1[i - n]
        }

        var firstPointer = n
        var secondPointer = 0

        for (i in nums1.indices) {
            val min = when {
                firstPointer != nums1.size && secondPointer != n && nums1[firstPointer] <= nums2[secondPointer] -> {
                    nums1[firstPointer].also { firstPointer++ }
                }
                firstPointer != nums1.size && secondPointer != n && nums1[firstPointer] > nums2[secondPointer] -> {
                    nums2[secondPointer].also { secondPointer++ }
                }
                secondPointer == n -> {
                    nums1[firstPointer].also { firstPointer++ }
                }
                else -> {
                    nums2[secondPointer].also { secondPointer++ }
                }
            }

            nums1[i] = min
        }
    }
}