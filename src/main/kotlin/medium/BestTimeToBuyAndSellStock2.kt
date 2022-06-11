package medium

/**
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
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