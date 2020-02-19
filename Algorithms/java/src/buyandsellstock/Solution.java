package buyandsellstock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

class Solution {
    // Time - O(n^2) - brute force solution, not optimal
    int maxProfit(int[] prices) {
        int maxProfit = 0, diff = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    diff = prices[j] - prices[i];
                    if (diff > maxProfit) {
                        maxProfit = diff;
                    }
                }
            }
        }
        return maxProfit;
    }
}

/*
Runtime: 265 ms, faster than 6.48% of Java online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 42.3 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.

 */