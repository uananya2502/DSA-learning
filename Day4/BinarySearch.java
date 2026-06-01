package Day4;

public class BinarySearch {
    public static int binarySearch(int [] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target==arr[mid])
                return mid;
            else if(arr[mid]<target){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] num = {10,20,30,40,50,60};
        int key = 20;
        System.out.println("Index for key is: " + binarySearch(num, key));
    }
}
