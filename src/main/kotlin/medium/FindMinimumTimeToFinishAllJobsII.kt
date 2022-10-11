package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 2323,
    title = "Find Minimum Time to Finish All Jobs II",
    link = "https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs-ii/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class FindMinimumTimeToFinishAllJobsII {

    fun minimumTime(jobs: IntArray, workers: IntArray): Int {
        jobs.sort()
        workers.sort()

        var max = 0

        jobs.zip(workers).forEach {
            max = maxOf(max, Math.ceil(it.first.toDouble() / it.second).toInt())
        }

        return max
    }
}