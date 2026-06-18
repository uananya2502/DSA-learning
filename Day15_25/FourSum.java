package Day15_25;
/*
LeetCode 18: 4Sum

Pattern:
- Sorting + Two Pointers

Idea:
- Sort the array.
- Fix the first element (i).
- Fix the second element (j).
- Find the remaining two elements using two pointers.
- This reduces 4Sum to a 2Sum problem.

Logic:
1. Sort the array.
2. For each i:
      skip duplicates.
3. For each j:
      skip duplicates.
4. Set:
      left = j + 1
      right = n - 1
5. Calculate:
      sum = nums[i] + nums[j] + nums[left] + nums[right]
6. If sum == target:
      add quadruplet
      skip duplicate left/right values
      left++, right--
7. If sum < target:
      left++
8. If sum > target:
      right--

Example:
nums = [1,0,-1,0,-2,2]
target = 0

Sorted:
[-2,-1,0,0,1,2]

Answer:
[
 [-2,-1,1,2],
 [-2,0,0,2],
 [-1,0,0,1]
]

Why Sorting?
- Enables two-pointer search.
- Helps avoid duplicate quadruplets.

Time Complexity: O(n³)
- i loop -> O(n)
- j loop -> O(n)
- Two pointers -> O(n)

Space Complexity: O(1)
- Ignoring output list.

Key Insight:
Fix two elements and convert the problem into a
2Sum search using two pointers.

Common Mistakes:
- Forgetting to sort.
- Not skipping duplicate i and j values.
- Not skipping duplicate left/right values.
- Integer overflow when calculating sum.

Important:
Use long for sum calculation:

long sum = (long) nums[i]
         + nums[j]
         + nums[left]
         + nums[right];

to avoid overflow.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 3; k++) {

            if (k > 0 && nums[k] == nums[k - 1]) continue;

            for (int i = k + 1; i < nums.length - 2; i++) {

                if (i > k + 1 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {

                    long sum = (long) nums[k]
                             + nums[i]
                             + nums[left]
                             + nums[right];

                    if (sum == target) {

                        ans.add(Arrays.asList(
                            nums[k],
                            nums[i],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right &&
                               nums[left] == nums[left - 1])
                            left++;

                        while (left < right &&
                               nums[right] == nums[right + 1])
                            right--;
                    }
                    else if (sum < target) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
