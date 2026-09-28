package Recurrsion;
public class SumRecurrsion {
    
    public static int sum(int [] arr, int i){
        if(i == arr.length-1){
            return arr[i];
        }
        int s = arr[i] + sum(arr, i+1);
        return s;
    }
    public static void main(String [] args){
        int [] arr = {10, 2, 5, 7, 1, 3};
        System.out.println(sum(arr, 0));
    }
}
