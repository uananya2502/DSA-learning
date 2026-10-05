public class SquareRoot {
    public int floorSqrt(int n) {
        int low =1; 
        int high = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            int i = mid*mid;
            if(i==n){
                return mid;
            }else if(i<n){
                low = mid +1;
            }else{
                high = mid -1;
            }
        } 
        return high;
    }
}
