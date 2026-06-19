package Day15_25;

import java.util.HashMap;

public class AllSubarrayXor {
    public int subarraysWithXorK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixor = 0;
        int count = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefixor ^= nums[i];

            int target = prefixor ^ k;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(prefixor, map.getOrDefault(prefixor, 0) + 1);
        }

        return count;
    }
}
