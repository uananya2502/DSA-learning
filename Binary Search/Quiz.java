import java.util.*;
public class Quiz {
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        char k = s.next().charAt(0);
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.next().charAt(0);
        }
        
        System.out.println(seat(arr,k));
    }
    public static char seat(char[] arr, char k){
        int low =0;
        int high = arr.length-1;
        char ans = arr[0];
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>k){
                ans = arr[mid];
                high = mid-1;

            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}
