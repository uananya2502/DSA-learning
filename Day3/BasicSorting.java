import java.util.*;

public class BasicSorting{
    public static void bubbleSort(int[] arr){
        for(int turn =0; turn <=arr.length-1; turn++){
            boolean swap=false;
            for(int j=0; j<arr.length-1-turn; j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                    swap=true;
                }
            }
            if(!swap)
                break;
        }
    }

    public static void selectionSort(int[] arr){
        for(int i =0; i<arr.length-1; i++){
            int minp = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minp]< arr[j])
                    minp =j;
            }
            int temp = arr[minp];
            arr[minp]= arr[i];
            arr[i]= temp;
        }
    }

    public static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0 && arr[prev]> curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }
    
    public static void main(String [] args){
        int[] a = [5,3,4,2,1];
        int[] b = [5,3,4,2,1];
        int[] c = [5,3,4,2,1];
        bubbleSort(a);
        selectionSort(b);
        insertionSort(c)

    }
}