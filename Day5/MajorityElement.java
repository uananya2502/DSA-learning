package Day5;

import java.util.HashMap;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
*/

/*
Approach:
1. Use a HashMap to store the frequency of each element in the array.
2. Traverse the array and update the count of each element using the HashMap.
3. Iterate through the HashMap entries and check the frequency of each element.
4. If an element's frequency is greater than n/2, return it as the majority element.
5. Since the majority element is guaranteed to exist, the required element will be found.
*/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int n = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n/2 ) {
                return entry.getKey(); 
            }
        }
        return 0;
    }
}
