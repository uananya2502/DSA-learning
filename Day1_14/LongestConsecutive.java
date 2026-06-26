package Day1_14;

import java.util.HashSet;
import java.util.Set;
/*
LeetCode 128: Longest Consecutive Sequence

Pattern:
- HashSet + Sequence Detection

Idea:
- Store all elements in a HashSet for O(1) lookup.
- A number is the start of a sequence only if (num - 1) does not exist.
- From the starting number, keep checking consecutive elements.
- Track the length of the longest sequence.

Logic:
1. Insert all numbers into a HashSet.
2. Iterate through the set:
   - If (num - 1) is not present, it is the beginning of a sequence.
   - Count consecutive numbers using (num + 1, num + 2, ...).
3. Update the maximum sequence length.

Example:
nums = [100, 4, 200, 1, 3, 2]

Set = {100, 4, 200, 1, 3, 2}

Start from 1:
1 -> 2 -> 3 -> 4
Length = 4

100 and 200 have no consecutive elements.

Answer = 4

Time Complexity: O(n)
- Each number is visited at most once.

Space Complexity: O(n)
- HashSet stores all unique elements.

Key Insight:
Do not start counting from every number.
Only start from numbers that do not have a previous consecutive number.
This avoids O(n²) checking and makes the solution O(n).
*/

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        Set<Integer> st = new HashSet<>();
        for(int num: nums){
            st.add(num);
        }
        int longest = 1;
        for(int it : st){
            if(!st.contains(it-1)){
                int ct =1;
                int x = it;
                while(st.contains(x+1)){
                    ct++;
                    x++;
                }
                longest = Math.max(longest, ct);
            }
        }
        return longest;
    }
}
