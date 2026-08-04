package August;

import java.util.Arrays;

public class AgrressiveCows {
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 1;
        int high = nums[nums.length - 1] - nums[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(nums, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean possible(int[] nums, int k, int dist) {
        int cow = 1;
        int lastplc = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastplc >= dist) {
                cow++;
                lastplc = nums[i];

                if (cow == k)
                    return true;
            }
        }

        return false;
    }
}
