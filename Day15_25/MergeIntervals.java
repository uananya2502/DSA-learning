package Day15_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
LeetCode 56: Merge Intervals

Pattern:
- Sorting + Interval Merging

Idea:
- Sort intervals based on start time.
- Compare the current interval with the previous merged interval.
- If they overlap, merge them.
- Otherwise, add the previous interval to the answer and move on.

Overlap Condition:
prev.end >= curr.start

Merge:
prev.end = max(prev.end, curr.end)

Logic:
1. Sort intervals by start time.
2. Initialize prev = first interval.
3. Traverse remaining intervals:
   - If overlapping:
         merge intervals.
   - Else:
         add prev to answer.
         prev = current interval.
4. Add the last interval.

Example:
intervals = [[1,3],[2,6],[8,10],[15,18]]

Sorted:
[[1,3],[2,6],[8,10],[15,18]]

Merge:
[1,3] + [2,6] -> [1,6]

Answer:
[[1,6],[8,10],[15,18]]

Time Complexity: O(n log n)
- Sorting dominates.

Space Complexity: O(n)
- Result list stores merged intervals.

Key Insight:
After sorting, overlapping intervals will always
appear next to each other, allowing a single pass merge.

Common Mistakes:
- Forgetting to sort first.
- Missing the final ans.add(prev).
- Using > instead of >= for overlap checking.
*/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                ans.add(prev);
                prev = curr;
            }
        }

        ans.add(prev);

        return ans.toArray(new int[ans.size()][]);
    }
}
