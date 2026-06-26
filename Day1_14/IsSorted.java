package Day1_14;

import java.util.ArrayList;

/*
    I compare each element with the next one. If any element is larger 
    than its successor, the array isn't sorted. Otherwise it is sorted. Time O(n), Space O(1).
*/
public class IsSorted {
    public boolean isSorted(ArrayList<Integer> nums) {
        //your code goes here
        for(int i =0; i < nums.size()-1; i++){
            if(nums.get(i) > nums.get(i+1))
                return false;
        }
        return true;
    }
}
