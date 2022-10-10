package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1817,
    title = "Finding the Users Active Minutes",
    link = "https://leetcode.com/problems/finding-the-users-active-minutes/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class FindingTheUsersActiveMinutes {

    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val res = IntArray(k)
        val map = HashMap<Int, MutableSet<Int>>()

        logs.forEach { entry ->
            val userActivity = map[entry[0]] ?: HashSet()
            userActivity.add(entry[1])
            map[entry[0]] = userActivity
        }

        map.values
            .map { it.size }
            .forEach { activityMinutesCount ->
                if (activityMinutesCount in 1..k) {
                    res[activityMinutesCount - 1] += 1
                }
            }

        return res
    }
}