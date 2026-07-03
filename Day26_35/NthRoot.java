package Day26_35;

public class NthRoot {
    public int NthRoot(int N, int M) {
        int low =1, high = M;
        while(low<=high){
            long mid = low+ (high-low)/2;
            int value = (int) Math.pow(mid, N);
            if(value==M){
                return (int)mid;
            }else if(value< M){
                low = (int) mid + 1;
            }else{
                high = (int) mid - 1;
            }
        }
        return -1;
    }
}
