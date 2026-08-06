package August;

public class PaintersPartition {
    public int paint(int A, int B, int[] C) {
        int low=0;
        int high = 0;
        int ans =0;
        for(int n : C){
            low = Math.max(low, n);
            high+=n;
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(C, mid, A)){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return (int)(((long)ans*B)%10000003);
    }
    boolean possible(int[] nums, int maxT, int p){
        int pnt = 1;
        int sum = 0;
        for(int n: nums){
            if(sum+n <= maxT){
                sum+=n;
            }else{
                pnt++;
                sum=n;
            }
            if(pnt>p){
                return false;
            }
        }
        return true;
    }
}

