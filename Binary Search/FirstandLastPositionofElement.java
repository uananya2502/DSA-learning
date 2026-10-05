

public class FirstandLastPositionofElement {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums, target), last(nums, target)};
    }
    public static int first(int [] nums, int k){
        int low = 0;
        int high = nums.length-1;
        int f = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==k){
                f = mid;
                high = mid-1;
            }else if (nums[mid]<k){
                low = mid +1;
                
            }else{
                high = mid-1;
            }
        }
        return f;
    }
    public static int last(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;
        int l = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==k){
                l = mid;
                low = mid+1;
            }else if (nums[mid]<k){
                low = mid +1;
                
            }else{
                high = mid-1;
            }
        }
        return l;
    }
    
}
