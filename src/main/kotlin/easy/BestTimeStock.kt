package easy

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 121,
    title = "Best Time to Buy and Sell Stock",
    link = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/",
    difficulty = ProblemDifficulty.EASY,
)
class BestTimeStock {

    fun maxProfit(prices: IntArray): Int {
        var lastCheapest = prices.first()
        var profit = 0

        prices.forEach { currentPrice ->
            if (lastCheapest > currentPrice) lastCheapest = currentPrice
            if (lastCheapest < currentPrice) {
                val potentialProfit = currentPrice - lastCheapest
                if (potentialProfit > profit) profit = potentialProfit
            }
        }

        return profit
    }
}