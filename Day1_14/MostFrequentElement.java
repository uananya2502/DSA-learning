package Day1_14;
import java.util.*;
/*
    Given an array nums of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times. 
    If there are multiple elements that appear a maximum number of times, find the smallest of them.
*/

// Approach:
// Use a HashMap to store the frequency of each element, where the key represents
// the array element and the value represents its frequency. First, traverse the
// array and build the frequency map in O(n) time. Then, iterate through the map
// to find the element with the highest frequency. If multiple elements have the
// same maximum frequency, return the smallest element among them. This approach
// avoids the O(n²) brute-force solution and achieves O(n) time complexity with
// O(n) extra space.


public class MostFrequentElement{
    public int mostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max = 0;
        int min_ele = 0;

        for(Integer key : map.keySet()){
            if(max < map.get(key)){
                max = map.get(key);
                min_ele= key;
            }
            else if(max==map.get(key)){
                min_ele = Math.min(min_ele, key );
            }
        }
        return min_ele;
    }
}
