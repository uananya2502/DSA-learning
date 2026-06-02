package Day5;
import java.util.HashMap;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
*/
/*
APPROACH:

1. Store the value of each Roman numeral in a HashMap.
2. Traverse the string from right to left.
3. Keep track of the previous numeral value (prev).
4. For each current numeral:
      - If current value is smaller than prev,
        subtract it from the answer.
      - Otherwise, add it to the answer.
5. Update prev to the current value.
6. Return the final result.

WHY IT WORKS?

In Roman numerals:
    IV = 5 - 1 = 4
    IX = 10 - 1 = 9
    XL = 50 - 10 = 40
    XC = 100 - 10 = 90
    CD = 500 - 100 = 400
    CM = 1000 - 100 = 900

When traversing from right to left:
    - If a smaller value appears before a larger value,
      subtract it.
    - Otherwise, add it.

Example:
    MCMIV

    V = +5
    I = -1
    M = +1000
    C = -100
    M = +1000

    Answer = 1904

TIME COMPLEXITY:
    O(n)

SPACE COMPLEXITY:
    O(1)

where n = length of the Roman numeral string.
*/ 

public class RomanToInt {
    public static int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num = 0;
        int prev = 0 ;
        for(int i = s.length()-1 ;i>=0; i-- ){
            int curr = map.get(s.charAt(i));
            if(curr < prev)   
                num -= curr;
            else{
                num+=curr;
            }
            prev = curr;
        }
        return num;
    }
    public static void main(String[] args) {
        String s = "IV";
        int n = romanToInt(s);
        System.out.println(n);
    }
}
