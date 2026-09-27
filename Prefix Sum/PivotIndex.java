public class PivotIndex {
    public int pivotIndex(int[] nums){
        int left = 0;
        int sum = 0;
        for(int num : nums){
            sum+=num;
        }
        int right = sum- nums[0];
        if(left == right){
            return 0;
        }
        for(int i = 1; i<nums.length; i++){
            left = left + nums[i-1];
            right = right- nums[i];
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
