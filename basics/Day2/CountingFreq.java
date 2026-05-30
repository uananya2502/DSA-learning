import java.util.*;

//Hashmap
/*
    Given an array nums of size n which may contain duplicate elements.
    Return a list of pairs where each pair contains a unique element from the array and its frequency in the array.
    You may return the result in any order, but each element must appear exactly once in the output.
/*
Brute Force Approach:
- For every element, traverse the entire array to count its frequency.
- Time Complexity = O(n²)

Optimized Approach using HashMap:
- HashMap stores key-value pairs.
- Key   = Element from nums[]
- Value = Frequency of that element

First, we traverse the array and store/update the frequency of each element in the HashMap.

Example:
nums = [1, 2, 2, 3, 1, 1]

HashMap:
1 -> 3
2 -> 2
3 -> 1

Then, we use entrySet() to access all key-value pairs of the HashMap.
Each entry contains:
- entry.getKey()   -> element
- entry.getValue() -> frequency

For every entry, we create a pair [element, frequency]
and add it to the result list.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class CountingFreq{
    public List<List<Integer>> countFreq (int [] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            res.add(pair);
        } 
        return res;

    }
    public static void main(String[] args) {
        CountingFreq sol = new CountingFreq();
        int[] nums = {1, 2, 2, 3, 1, 1};

        List<List<Integer>> ans = sol.countFreq(nums);

        for (List<Integer> pair : ans) {
            System.out.println(pair);
        }
    }
}