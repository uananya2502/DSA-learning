package Day15_25;
/*
LeetCode 229: Majority Element II

Pattern:
- Boyer-Moore Voting Algorithm

Idea:
- An element appearing more than ⌊n/3⌋ times can be at most 2 elements.
- Maintain two candidates and their counts.
- First pass finds potential candidates.
- Second pass verifies whether they actually occur > n/3 times.

Logic:
1. If current number matches a candidate:
      increase its count.
2. If a candidate count becomes 0:
      replace that candidate.
3. Otherwise:
      decrease both counts.
4. Verify candidates in a second traversal.

Why at most 2 candidates?
- More than two elements cannot each occur > n/3 times,
  because their total occurrences would exceed n.

Example:
nums = [3,2,3]

Candidate1 = 3
Candidate2 = 2

Final frequencies:
3 -> 2 times (> n/3)

Answer = [3]

Time Complexity: O(n)
- One pass for candidate selection.
- One pass for verification.

Space Complexity: O(1)
- Only two candidates and two counters.

Key Insight:
Pairwise cancel different elements.
The elements surviving the cancellations are the only possible
majority elements (> n/3).
*/
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int c1=0, c2=0;
        int num1 =0, num2=0;
        for (int num : nums) {
    if (num == num1) {
        c1++;
    } else if (num == num2) {
        c2++;
    } else if (c1 == 0) {
        num1 = num;
        c1 = 1;
    } else if (c2 == 0) {
        num2 = num;
        c2 = 1;
    } else {
        c1--;
        c2--;
    }
}
        c1=0;
        c2=0;
        for(int num: nums){
            if(num==num1)
                c1++;
            else if (num==num2)
                c2++;
        }
        if(c1>nums.length/3)
            ans.add(num1);
        if(c2>nums.length/3)
            ans.add(num2);

        return ans;
    }
}
