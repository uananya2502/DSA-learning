package Day15_25;
/*
LeetCode 118: Pascal's Triangle

Pattern:
- Math + Combinatorics

Idea:
- First and last element of every row is 1.
- Each middle element is the sum of the two elements
  directly above it.
- Can also generate a row using nCr values.

Formula:
nCr = nC(r-1) * (n-r+1) / r

Logic:
1. Start each row with 1.
2. Generate remaining elements using the previous value.
3. Add the completed row to the answer.
4. Repeat for all rows.

Example:
numRows = 5

[
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
]

Time Complexity: O(n²)
- Total elements generated = 1 + 2 + ... + n

Space Complexity: O(1) extra
- Ignoring output storage.

Key Insight:
Each row represents the binomial coefficients:
(nC0, nC1, nC2, ..., nCn)

Common Mistakes:
- Incorrect nCr formula.
- Integer overflow for larger rows (use long while computing).
- Mixing 0-based and 1-based row indexing.
*/
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleI {
    public static List<List<Integer>> generate(int rows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i<rows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<i; j++){
                if(j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j-1));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
