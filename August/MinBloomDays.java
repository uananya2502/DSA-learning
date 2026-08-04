package August;

public class MinBloomDays {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length)
            return -1;

        int low = bloomDay[0], high = bloomDay[0];

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean possible(int[] arr, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int x : arr) {
            if (x <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }

        bouquets += count / k;

        return bouquets >= m;
    }
}
