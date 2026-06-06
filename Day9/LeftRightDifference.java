package Day9;
/*
Problem: Left and Right Sum Differences
Pattern:
* Prefix Sum

Difficulty:
* Easy

Key Observation:
* For every index i, we need:
  * Sum of elements on the left of i
  * Sum of elements on the right of i
* Calculating these sums separately for every index would lead to O(n²) time.
* Prefix and suffix sums allow us to precompute these values efficiently.

Thinking Process:
1. Need left and right sums for each position.
2. Notice that leftSum[i] can be built using leftSum[i-1].
3. Similarly, rightSum[i] can be built using rightSum[i+1].
4. Once both arrays are available:
   answer[i] = |leftSum[i] - rightSum[i]|

Approach:
1. Build leftSum array.
2. Build rightSum array.
3. Compute absolute difference for each index.
4. Store result in answer array.

Recognition Clue:
* Need sum of elements before or after every index.
* Multiple range sum calculations.
* Repeated sum queries over an array.
* Think Prefix Sum / Suffix Sum.

Time Complexity:
* O(n)

Space Complexity:
* O(n)

Optimization:
* Instead of storing rightSum array, use totalSum and running leftSum.
* Space can be reduced to O(1) (excluding output array).

Takeaway:
* Prefix Sum is useful whenever repeated sum calculations are required.
* Before using nested loops for sums, check if previous computations can be reused.
*/

public class LeftRightDifference {
    public int[] leftRightDifference(int[] nums) {

        int [] leftSum = new int[nums.length];
        int [] rightSum = new int[nums.length];
        int [] ans = new int[nums.length];
        leftSum[0]=0;
        rightSum[nums.length-1] = 0;
        for(int i = 1 ; i<nums.length; i++){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }
        for (int i = nums.length-2; i>=0; i--){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }
        for (int i=0; i<nums.length; i++){
            ans[i] = Math.abs(leftSum[i]-rightSum[i]);
        }
        return ans;
    }
}
