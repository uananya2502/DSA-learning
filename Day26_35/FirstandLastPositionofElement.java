package Day26_35;

public class FirstandLastPositionofElement {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums, target), last(nums, target)};
    }
    public int first(int[] nums, int x){
        int low =0, high = nums.length-1;
        int idx =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==x){
                idx = mid;
                high=mid-1;
            }else if (nums[mid]<x)
                low= mid+1;
            else
                high = mid-1;
        }
        return idx;

    }
    public int last(int[] nums, int x){
        int low =0, high = nums.length-1;
        int idx =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==x){
                idx = mid;
                low=mid+1;
            }else if (nums[mid]<x)
                low= mid+1;
            else
                high = mid-1;
        }
        return idx;
    }
}
