package Day4;
import java.util.*;
/*
Problem No: LeetCode 2144
Title: Minimum Cost of Buying Candies With Discount

Approach:
1. Sort the array in ascending order.
2. Traverse from the largest candy towards the smallest.
3. Consider candies in groups of 3.
4. Pay for first two candies in each group.
5. Skip the third candy (free candy).
6. Add only paid candies to the answer.

Observation:
- To minimize total cost, maximize the value of free candies.
- After sorting, every third candy from the largest side can be taken for free.

Complexity:
Time: O(n log n)  // sorting
Space: O(1)      // ignoring sorting space

What I Did:
- Sorted the array using Arrays.sort().
- Traversed from right to left.
- Used a counter to identify every third candy.
- Skipped every third candy and added the rest to sum.

Mistakes / Learning:
- Initially had to understand why taking expensive candies first helps.
- Learned that greedy works because we want the maximum possible free candy value.
*/

public class MinimumCost {
    public int minimumCost(int[] cost) {
        int count = 0;
        int sum = 0;
        Arrays.sort(cost);
        for(int i=cost.length-1; i>=0; i--){
            count++;
            if(count%3==0){
                continue;
            }
            sum+=cost[i];
        }
        return sum;
    }
    public static void main(String [] args){

    }
}
