package August;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> lst = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        for(int i = min+1; i<max; i++){
            if(!set.contains(i)){
                lst.add(i);
            }
        }
        return lst;

    }
}
