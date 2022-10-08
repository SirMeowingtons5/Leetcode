package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1282,
    title = "Group the People Given the Group Size They Belong To",
    link = "https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val res = ArrayList<List<Int>>()

        val incompleteGroups = HashMap<Int, MutableList<Int>>()

        groupSizes.forEachIndexed { index, size ->
            val group = incompleteGroups[size] ?: ArrayList()
            group.add(index)
            if (group.size == size) {
                incompleteGroups.remove(size)
                res.add(group)
            } else if (!incompleteGroups.contains(size)) {
                incompleteGroups[size] = group
            }
        }

        return res
    }
}