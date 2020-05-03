package covid19.day5_best_time_to_buy_and_sell_stock_II;

class Solution {
    public static void main(String[] args) {
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // We only need to consider the diff price of 2 nearby day
            // Example: We have [1,3,8]
            // If we buy at day 1 (1$), then the next day the price is higher --> we sell and got Profit = 2$.
            // Then next day it go up to 8, so if we hold from day 1 to day 3, we will get higher profit.
            // But, because we always take the diff between 2 nearby day, the profit is always the maximum.
            // It's same as we buy at day 1 (1$), then sell at day 2 (3$), then we buy back at 3$, then sell the next day (8$)
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}