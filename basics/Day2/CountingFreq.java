import java.util.*;

//Hashmap
/*
Given an array nums of size n which may contain duplicate elements.
Return a list of pairs where each pair contains a unique element from the array and its frequency in the array.
You may return the result in any order, but each element must appear exactly once in the output.
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