package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty
import java.util.*

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 346,
    title = "Moving Average from Data Stream",
    link = "https://leetcode.com/problems/moving-average-from-data-stream/",
    difficulty = ProblemDifficulty.EASY,
)
class MovingAverage(private val size: Int) {

    private val list = LinkedList<Int>()
    private var sum = 0.0

    fun next(`val`: Int): Double {
        if(list.size == size) {
            sum -= list[0]
            list.removeAt(0)
        }

        list.add(`val`)
        sum += `val`

        return sum / list.size
    }
}