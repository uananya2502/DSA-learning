package Day26_35;

public class countOccurance {
    public int countOccurrences(int[] arr, int target) {

        int first = first(arr, target);

        if (first == -1)
            return 0;

        int last = last(arr, target);

        return last - first + 1;
    }

    public int first(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == x) {
                idx = mid;
                high = mid - 1;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return idx;
    }

    public int last(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == x) {
                idx = mid;
                low = mid + 1;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return idx;
    }
}

