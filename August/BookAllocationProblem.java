package August;

public class BookAllocationProblem {
    public int findPages(int[] nums, int m) {
        if(m>nums.length){
            return -1;
        }
        int low = nums[0];
        int high = 0;
        for(int pages: nums){
            low = Math.max(low, pages);
            high+= pages;
        }
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(nums, mid, m)){
                ans = mid;
                high=mid-1;
            }else{
                low=mid +1;
            }
        }
        return ans;
    }
    boolean possible(int[] nums, int maxp, int m){
        int stu =1;
        int pages = 0;
        for(int book: nums){
            if(book+pages<=maxp){
                pages+=book;
            }else{
                pages = book;
                stu++;
            }
            if(stu>m)
                return false;
        }
        return true;
    }
}

