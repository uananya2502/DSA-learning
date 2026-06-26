package Day1_14;

/*
LeetCode 121: Best Time to Buy and Sell Stock

Pattern:
- Array + Greedy + Prefix Minimum

Idea:
- Keep track of the minimum stock price seen so far.
- For every day, calculate profit if sold today.
- Update maximum profit.

Logic:
minPrice = lowest buying price till current day
profit = currentPrice - minPrice
maxProfit = maximum profit seen so far

Example:
prices = [7,1,5,3,6,4]

Day 1: min = 7, profit = 0
Day 2: min = 1, profit = 0
Day 3: profit = 5-1 = 4
Day 5: profit = 6-1 = 5 (maximum)

Time Complexity: O(n)
Space Complexity: O(1)

Key Insight:
While traversing, maintain the best buying price from the left
and calculate the best profit for each selling day.
*/

public class StockBuySell {
    public static int stockBuySell(int[] nums){
        int buy = nums[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i<nums.length; i++){
            int curr = nums[i]- buy;
            maxProfit = Math.max(curr, maxProfit);
            buy = Math.min(buy, nums[i]);
        }
        return maxProfit;
    }
}
