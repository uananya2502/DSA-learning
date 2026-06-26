package Day1_14;
// 75. Sort Colors

/*
    We have given an array of which contain only three number and we have to sort in place without
    using sorting algos:
    Approch: 
        Take three pointers and while incremanting midlle pointer while cheching and swapping 
        with low and high pointers.
*/

public class SortColours {
    public static void sortColours(int [] nums){
        int mid =0, low=0, high= nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1)
                mid++;
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
