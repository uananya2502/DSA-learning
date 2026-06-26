package Day1_14;
/*
Brute force Approch:
    Take three dynamic arrays for <pivot, =pivot,>pivot then merge these three array into single one by one left, equal, right.
Optimal Approch:
    Take another array now using two pointers first and last add element less thant pivot using first pointer and greater than pivot using 
    last pointer increase first pointer , decrease last pointer this will how we can maintain order of elements
Time: O(n)
Space: O(n)
*/
public class PivotArray {
    public static int[] pivotArray(int[] nums , int pivot){
        int [] result = new int[nums.length];
        int left =0;
        int right = nums.length-1;
        for(int i =0, j=nums.length-1; i<nums.length; i++, j--){
            if(nums[i]<pivot){
                result[left]=nums[i];
                left++;
            }
            if(nums[j]>pivot){
                result[right]=nums[j];
                right--;
            }
        }
        while(left<=right){
            result[left]=pivot;
            left++;
        }
        return result;
    }
}
