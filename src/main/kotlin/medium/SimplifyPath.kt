package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 71,
    title = "Simplify Path",
    link = "https://leetcode.com/problems/simplify-path/submissions/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class SimplifyPath {

    fun simplifyPath(path: String): String {
        val files = ArrayList<String>()
        val currentPath = StringBuilder()

        for (i in 0 until path.length) {
            if (path[i] != '/') {
                currentPath.append(path[i])
            }
            if (path[i] == '/' || i == path.length - 1) {
                if (currentPath.isNotEmpty()) {
                    val file = currentPath.toString()

                    if (file == "..") {
                        if (files.isNotEmpty()) files.removeAt(files.size - 1)
                    } else if (file != ".") {
                        files.add(file)
                    }

                    currentPath.clear()
                }
            }
        }

        currentPath.clear()

        return currentPath.append('/').append(files.joinToString("/")).toString()
    }
}