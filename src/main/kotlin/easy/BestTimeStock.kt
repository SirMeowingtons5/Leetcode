package easy

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

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