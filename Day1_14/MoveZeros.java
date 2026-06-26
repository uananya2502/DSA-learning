package Day1_14;
/*
Problem: Move Zeroes
Key Observation:
* The order of non-zero elements must remain unchanged.
* We only need to move all non-zero elements to the front.
* Once all non-zero elements are placed correctly, the remaining positions can be filled with zeros.

Thinking Process:
1. Ignore the zeroes initially.
2. Collect all non-zero elements at the beginning of the array.
3. Keep track of the next available position using a write pointer.
4. After placing all non-zero elements, fill the remaining positions with zeros.

Approach:
1. Maintain a write pointer j = 0.
2. Traverse the array using i.
3. If nums[i] is non-zero:

   * Place it at index j.
   * Increment j.
4. After traversal, all non-zero elements are in their correct relative order.
5. Fill indices from j to n-1 with zeros.

Pattern Used:
* Two Pointers
  * Read Pointer (i)
  * Write Pointer (j)

Recognition Clue:
* If the problem asks to filter elements while preserving their relative order and doing it in-place, think Read/Write Two Pointer technique.

Time Complexity:
* O(n)

Space Complexity:
* O(1)

Takeaway:
* Two pointers are useful when reading data from one position and writing valid data to another position.
* This pattern appears in problems involving filtering, removing elements, and compacting arrays.

*/
public class MoveZeros {
    public static void moveZeros(int [] nums){
        int k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[k]= nums[i];
                k++;
            }
        }
        for(int i=k; i<nums.length; i++){
            nums[i]=0;
        }
    }
}
