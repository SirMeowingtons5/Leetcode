package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 811,
    title = "Subdomain Visit Count",
    link = "https://leetcode.com/problems/subdomain-visit-count/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class SubdomainVisitCount {

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val visitedDomains = HashMap<String, Int>()

        cpdomains.forEach { s ->
            val spaceIndex: Int = s.indexOf(' ')
            val visitCount: Int = s.substring(0, spaceIndex).toInt()
            var domain: String = s.substring(spaceIndex + 1)

            while (domain.isNotEmpty()) {
                visitedDomains[domain] = (visitedDomains[domain] ?: 0) + visitCount
                val dotIndex = domain.indexOf('.')
                domain = if (dotIndex != -1) {
                    domain.substring(dotIndex + 1)
                } else {
                    ""
                }
            }
        }
        return visitedDomains.map { "${it.value} ${it.key}" }
    }
}