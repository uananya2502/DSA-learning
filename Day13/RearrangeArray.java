package Day13;
/*
LeetCode 2149: Rearrange Array Elements by Sign

Pattern:
- Array + Two Pointers + Extra Array

Idea:
- Positive numbers should be placed at even indices.
- Negative numbers should be placed at odd indices.
- Use two pointers to track the next available positions.

Logic:
pos = 0  -> next position for positive numbers
neg = 1  -> next position for negative numbers

Traverse the array:
- If number is positive, place it at pos and move pos += 2.
- If number is negative, place it at neg and move neg += 2.

Example:
nums = [3,1,-2,-5,2,-4]

ans = [3,-2,1,-5,2,-4]

Time Complexity: O(n)
- Single traversal of the array.

Space Complexity: O(n)
- Extra array is used to store the result.

Key Insight:
Maintain separate indices for positive and negative positions
to preserve the original relative order while alternating signs.
*/
public class RearrangeArray {
    public static int[] rearrangeArray(int [] nums){
        int [] ans = new int[nums.length];
        int i=0, j=0, k=0;
        for(i=0;i<nums.length; i++){
            if(nums[i]>0){
                ans[j]=nums[i];
                j+=2;
            }else{
                ans[k]=nums[i];
                k+=2;
            }
        }
        return ans;

    }
    
}
