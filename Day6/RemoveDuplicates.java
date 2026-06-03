package Day6;
/*
Problem: Remove Duplicates from Sorted Array
Key Observation:
* The array is already sorted.
* In a sorted array, duplicate elements always appear next to each other.
* Therefore, to determine whether an element is unique, it is sufficient to compare it with the previous element.
* There is no need to check all earlier elements.

Pattern Used:
* Two Pointers

  * One pointer scans the array (read pointer).
  * One pointer tracks where the next unique element should be placed (write pointer).
* This allows modification of the array in-place without using extra space.

Approach:
1. Keep the first element since it is always unique.
2. Traverse the array from the second element onward.
3. If the current element differs from the previous element:

   * Place it at the write pointer position.
   * Move the write pointer forward.
4. The final value of the write pointer represents the number of unique elements.

Time Complexity:
* O(n)

Space Complexity:
* O(1)

Takeaway:
* Whenever a problem mentions a sorted array, look for opportunities to use adjacent comparisons,
  two pointers, or binary search before considering hashing or nested loops.
*/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int k=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]){
                nums[k]= nums[i];
                k++;
            }
        }
        return k;
    }
}
