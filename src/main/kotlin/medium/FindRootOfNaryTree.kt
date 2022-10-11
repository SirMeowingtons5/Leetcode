package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import utils.Node

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 1506,
    title = "Find Root of N-Ary Tree",
    link = "https://leetcode.com/problems/find-root-of-n-ary-tree/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class FindRootOfNaryTree {

    fun findRoot(tree: List<Node>): Node? {
        val nodes = HashMap<Int, Node>()

        tree.forEach {node ->
            nodes[node.`val`] = node
        }

        tree.forEach {node ->
            node.children.filterNotNull().forEach {child ->
                nodes.remove(child.`val`)
            }
        }

        return nodes.values.firstOrNull()
    }
}