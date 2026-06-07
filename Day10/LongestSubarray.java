package Day10;

public class LongestSubarray {
    public static int longestSubarray(int[] nums, int k){
        int max = 0;
        int right = 0, left = 0;
        int sum = nums[0];
        int n = nums.length;
        while(right < n){
            while(left<=right && sum<k){
                sum-=nums[left];
                left++;
            }
            if(sum==k){
                max = Math.max(max, right-left+1);
            }
            right++;
            if(right<n){
                sum+=nums[right];
            }
        }
        return max ;
    }
}
