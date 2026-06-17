package Day15_25;
/*
Count Subarrays With Given Sum (LeetCode 560)

Pattern:
- Prefix Sum + HashMap

Idea:
- If current prefix sum = sum
- We need a previous prefix sum = (sum - k)
- Then the subarray between them has sum = k.

Formula:
currentSum - previousSum = k
previousSum = currentSum - k

Logic:
1. Maintain running prefix sum.
2. Store frequency of prefix sums in a HashMap.
3. For each element:
   - Update prefix sum.
   - Check if (prefixSum - k) exists in map.
   - Add its frequency to answer.
   - Store current prefix sum in map.

Example:
nums = [1,1,1], k = 2

Prefix Sums:
1, 2, 3

At sum = 2:
(2 - 2) = 0 found once
count = 1

At sum = 3:
(3 - 2) = 1 found once
count = 2

Answer = 2

Time Complexity: O(n)
- Single traversal of array.

Space Complexity: O(n)
- HashMap stores prefix sums.

Key Insight:
Instead of checking every subarray,
use prefix sums and count how many times
(prefixSum - k) has appeared before.
*/
import java.util.HashMap;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixsum = 0;
        int count =0;

        for(int num : nums){
            prefixsum += num;
            int remove = prefixsum -k;
            if(map.containsKey(remove)){
                count+=map.get(remove);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum, 0)+1);
        }
        return count;
    }
}
