package Day15_25;
/*
LeetCode 35: Search Insert Position

Pattern:
- Binary Search

Idea:
- Find the target in a sorted array.
- If found, return its index.
- If not found, return the index where it should be inserted.
- The insertion position is the first index where nums[i] >= target.

Logic:
1. Initialize low = 0, high = n - 1.
2. While low <= high:
   - mid = low + (high - low) / 2
   - If nums[mid] == target:
         return mid
   - If nums[mid] < target:
         search right half
   - Else:
         search left half
3. If target is not found, low is the insertion index.

Example:
nums = [1,3,5,6], target = 5
Output: 2

nums = [1,3,5,6], target = 2
Output: 1

nums = [1,3,5,6], target = 7
Output: 4

Time Complexity: O(log n)
- Binary search halves the search space each iteration.

Space Complexity: O(1)

Key Insight:
After binary search ends, 'low' points to the first position
where the target can be inserted while maintaining sorted order.

Common Mistakes:
- Returning high instead of low.
- Using (low + high) / 2 (may overflow).
- Forgetting to return low when the target is not found.
*/
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low=0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low) /2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
