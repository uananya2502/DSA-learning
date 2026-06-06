package Day8;

public class Kadane {
    public static int kadane(int[] nums){
        int ms = Integer.MIN_VALUE;
        int cs = nums[0];
        for(int i =1; i< nums.length; i++){
            cs = Math.max(cs, cs + nums[i]);
            ms = Math.max(cs, ms);
        }
        return ms;
    }
    public static void main(String [] args){
        int [] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadane(nums));
    }
}
