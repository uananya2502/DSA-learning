package August;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        int low = 1;

        for (int i : nums) {
            max = Math.max(i, max);
        }

        if (threshold == nums.length) {
            return max;
        }

        while (low < max) {
            int mid = low + (max - low) / 2;

            if (sumD(nums, mid, threshold)) {
                low = mid + 1;
            } else {
                max = mid;
            }
        }

        return low;
    }

    boolean sumD(int[] arr, int mid, int thres) {
        int sum = 0;

        for (int i : arr) {
            sum += (i + mid - 1) / mid;
        }

        return sum > thres;
    }
}
