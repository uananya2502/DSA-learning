package Day1_14;

import java.util.HashMap;

public class LongestSubarrayK {
    public static int longestSubarray(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum==k){
                max = i+1;
            }
            if(map.containsKey(sum-k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return max;
    }
}
