package Day15_25;
/*
LeetCode 15: 3Sum

Pattern:
- Sorting + Two Pointers

Idea:
- Sort the array.
- Fix one element nums[i].
- Find two other elements whose sum = -nums[i].
- Use two pointers on the remaining sorted array.

Logic:
1. Sort the array.
2. For each index i:
   - Skip duplicates.
   - Set left = i + 1, right = n - 1.
3. Calculate:
      sum = nums[i] + nums[left] + nums[right]
4. If sum == 0:
      add triplet
      skip duplicate left/right values
5. If sum < 0:
      left++
6. If sum > 0:
      right--

Example:
nums = [-1,0,1,2,-1,-4]

After sorting:
[-4,-1,-1,0,1,2]

Triplets:
[-1,-1,2]
[-1,0,1]

Answer:
[[-1,-1,2],[-1,0,1]]

Why Sorting?
- Enables two-pointer search.
- Makes duplicate removal easy.

Time Complexity: O(n²)
- Outer loop: O(n)
- Two pointers: O(n)

Space Complexity: O(1)
- Ignoring output list.

Key Insight:
Fix one element and reduce 3Sum to a 2Sum problem
using two pointers on the sorted array.

Common Mistakes:
- Forgetting to sort.
- Not skipping duplicate i values.
- Not skipping duplicate left/right values after finding a triplet.
- Moving both pointers incorrectly.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int [] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } 
                else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
