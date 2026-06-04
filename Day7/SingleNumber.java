package Day7;

/*
Problem: Single Number

Key Observation

Every number appears exactly twice except one.
Duplicate numbers can cancel each other.

Thinking Process

Need O(n) time and O(1) space.
HashMap violates O(1) space.
XOR has the property that a number XOR itself becomes 0.
All pairs cancel out, leaving only the unique element.

Pattern Used

Bit Manipulation
XOR

Recognition Clue

"Every element appears twice except one"
"Constant extra space"
Think XOR immediately.

Important XOR Properties

a ^ a = 0
a ^ 0 = a

Time Complexity

O(n)

Space Complexity

O(1)

Takeaway

XOR is often used when pairs need to cancel out and only one unique element remains.
*/

public class SingleNumber {
    public static int singlenumber(int [] nums){
        int xor = 0;
        for(int num : nums){
            xor ^= num;
        }
        return xor;
    }
}
