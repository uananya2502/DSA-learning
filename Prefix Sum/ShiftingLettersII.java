/*
LeetCode 2381 — Shifting Letters II

Each query shifts every character in [L,R].

Brute force:
For every query, modify every character in its range.
Worst case → O(N × Q)

Difference Array:
diff[L] += shift
diff[R+1] -= shift

Then prefix sum:
curr += diff[i]

curr = total shift affecting position i.

Character conversion:
'a' → 0
'b' → 1
...
'z' → 25

newPos = (oldPos + curr) mod 26

Because curr can be negative:
newPos = Math.floorMod(oldPos + curr, 26)

Complexity:
Time = O(N + Q)
Space = O(N)
*/
public class ShiftingLettersII {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int [n+1];
        
        for(int [] shift : shifts){
            int l = shift[0];
            int r = shift[1];
            int x = (shift[2]==1) ? 1 : -1;
            diff[l]+=x;
            diff[r+1]-=x;
        }
        StringBuilder ans = new StringBuilder();
        int curr = 0;

        for (int i = 0; i < n; i++) {

            curr += diff[i];
            int pos = Math.floorMod((s.charAt(i) - 'a') + curr, 26);
            char ch = (char) ('a' + pos);
            ans.append(ch);
        }

        return ans.toString();
    }
}
