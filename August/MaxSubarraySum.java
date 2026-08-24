package August;

public class MaxSubarraySum {
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0;
        int max = 0;
        int i =0, j =k;
        for(int l =0; l<k; l++){
            sum+=arr[l];
        }
        max = sum;
        while(j<arr.length){
            sum = sum - arr[i] + arr[j];
            max = Math.max(sum, max);
            i++;
            j++;
        }
        return max;
    }
}

