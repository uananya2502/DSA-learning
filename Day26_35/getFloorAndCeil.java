package Day26_35;

public class getFloorAndCeil {
    public int[] getFloorAndCeil(int[] nums, int x) {
        return new int[]{floor(nums, x), ceil(nums, x)};
    }

    public int floor(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int floor = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == x)
                return x;

            if (nums[mid] < x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }

    public int ceil(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == x)
                return x;

            if (nums[mid] < x) {
                low = mid + 1;
            } else {
                ceil = nums[mid];
                high = mid - 1;
            }
        }

        return ceil;
    }
}
