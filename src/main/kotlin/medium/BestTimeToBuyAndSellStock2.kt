package medium

import annotation.AlgorithmPlatform
import annotation.AlgorithmProblem
import annotation.ProblemDifficulty

@AlgorithmProblem(
    platform = AlgorithmPlatform.LEETCODE,
    number = 122,
    title = "Best Time to Buy and Sell Stock II",
    link = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/",
    difficulty = ProblemDifficulty.MEDIUM,
)
class BestTimeToBuyAndSellStock2 {

    fun maxProfit(prices: IntArray): Int {
        var totalProfit = 0
        var currentPrice = prices[0]

        prices.forEach { price ->
            if(currentPrice < price) {
                totalProfit += price - currentPrice
                currentPrice = price
            } else {
                currentPrice = price
            }
        }

        return totalProfit
    }
}