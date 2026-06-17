package Day15_25;

import java.util.HashMap;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixsum = 0;
        int count =0;

        for(int num : nums){
            prefixsum += num;
            int remove = prefixsum -k;
            if(map.containsKey(remove)){
                count+=map.get(remove);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum, 0)+1);
        }
        return count;
    }
}
