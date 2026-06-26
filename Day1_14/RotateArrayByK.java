package Day1_14;
/*
Problem: Rotate Array
Key Observation:
* After rotating the array to the right by k positions, the last k elements move to the front.
* The relative order of elements within the two groups remains unchanged.
* The final array can be viewed as:
  [First Part | Last k Elements]
  becoming
  [Last k Elements | First Part]

Example:
Original: [1,2,3,4 | 5,6,7]
Result:   [5,6,7 | 1,2,3,4]

Thinking Process:
1. Brute Force Idea:
   * Rotate the array one step at a time.
   * Repeat this process k times.
   * Correct but inefficient for large values of k.

2. Search for a Better Way:
   * We need to move the last k elements to the front without extra space.
   * Reversing parts of the array can help rearrange elements efficiently.

3. Key Insight:
   * Reverse the entire array.
   * Reverse the first k elements.
   * Reverse the remaining elements.
   * This restores the correct order within both groups.

Approach:
1. Compute k = k % n.
2. Reverse the entire array.
3. Reverse indices [0, k-1].
4. Reverse indices [k, n-1].
5. Array is rotated in-place.

Pattern Used:
* Array Reversal
* Two Pointers (inside reverse function)
* In-place Array Manipulation

Why Reversal Works:
Original:      [1,2,3,4,5,6,7]
Reverse All:  [7,6,5,4,3,2,1]
Reverse 0-2:  [5,6,7,4,3,2,1]
Reverse 3-6:  [5,6,7,1,2,3,4]

Time Complexity:

* O(n)

Space Complexity:
* O(1)

Takeaway:
* Whenever an array needs rearrangement in-place and extra space is restricted, think about reversing sections of the array.
* For rotation problems, always check if reversal can transform the array efficiently.

*/
public class RotateArrayByK {
    public void rotateArray(int [] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length);
    }
    public static void reverse(int[] a, int i, int j){
        while(i<j){
            int temp = a[i];
            a[i]= a[j];
            a[j] = temp;
            i++;
            j++;
        }
    }
}