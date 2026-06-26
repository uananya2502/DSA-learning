package Day1_14;
/*
LeetCode 31: Next Permutation

Pattern:
- Array + Greedy + Two Pointers + Reverse

Idea:
- Find the first index from the right where nums[i] < nums[i+1].
  This is the breakpoint where a larger permutation can be formed.
- Find the smallest element greater than nums[i] from the right.
- Swap both elements.
- Reverse the part after the breakpoint to get the next smallest arrangement.

Logic:
1. Traverse from right and find breakpoint (idx):
   nums[idx] < nums[idx + 1]

2. If no breakpoint exists:
   - Array is in descending order (largest permutation).
   - Reverse the entire array to get the smallest permutation.

3. Otherwise:
   - Find the next greater element from the right.
   - Swap it with nums[idx].
   - Reverse the suffix (idx + 1 to end).

Example:
nums = [1, 2, 3]

Breakpoint = 1 (value 2)
Swap with 3 -> [1, 3, 2]
Reverse remaining part -> [1, 3, 2]

Example:
nums = [1, 3, 2]

Breakpoint = 0 (value 1)
Swap with 2 -> [2, 3, 1]
Reverse suffix -> [2, 1, 3]

Time Complexity: O(n)
- One pass to find breakpoint.
- One pass to find next greater element.
- One pass to reverse suffix.

Space Complexity: O(1)
- Operations are done in-place.

Key Insight:
Find the first decreasing point from the right, replace it with
the next greater element, and make the remaining suffix as small
as possible by reversing it.
*/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int idx =-1;
        for(int i = nums.length-1; i>=1;i--){
            if(nums[i-1]<nums[i]){
                idx = i-1;
                break;
            }
        }
        if(idx == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        for(int i=nums.length-1; i>idx;i--){
            if(nums[i]>nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }
        reverse(nums, idx+1, nums.length-1);

    }
    public static void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i]= nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
     public static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i]= nums[j];
        nums[j]=temp;
     }
}
