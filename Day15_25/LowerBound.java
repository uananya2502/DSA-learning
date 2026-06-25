package Day15_25;
/*
Lower Bound

Pattern:
- Binary Search

Definition:
- Finds the first index where nums[i] >= target.
- If no such element exists, returns n.

Logic:
1. Initialize ans = n.
2. If nums[mid] >= target:
      ans = mid;
      search left half.
3. Else:
      search right half.
4. Return ans.

Example:
nums = [1,2,2,3,5]
target = 2

Lower Bound = 1

Time Complexity: O(log n)
Space Complexity: O(1)

Key Insight:
Find the first element that is greater than or equal to the target.
*/
public class LowerBound {
    public int lowerBound(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;
        while(low<high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=x){
                ans = mid;
                high = mid -1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
