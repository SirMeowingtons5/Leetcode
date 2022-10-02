package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 278,
    title = "First Bad Version",
    link = "https://leetcode.com/problems/first-bad-version/",
    difficulty = ProblemDifficulty.EASY,
)
class FirstBadVersion(private val bad: Int) {

    fun firstBadVersion(n: Int): Int {
        var right = n
        var left = 0
        var mid: Int

        while (left < right) {
            mid = left + (right - left) / 2

            if(isBadVersion(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun isBadVersion(n: Int): Boolean = bad == n
}