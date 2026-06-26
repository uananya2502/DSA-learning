package Day1_14;

/*
Problem: Maximum Consecutive Ones
Key Observation

Consecutive 1s form a streak.
A 0 breaks the streak.
We only need the longest streak.

Thinking Process
Count current consecutive 1s.
Reset count when a 0 appears.
Continuously update the maximum streak.

Pattern Used
Array Traversal
Running Count

Recognition Clue
Words like "maximum consecutive", "longest streak", "continuous sequence" usually suggest maintaining a running count while traversing.

Time Complexity
O(n)

Space Complexity
O(1)

Takeaway
When asked for the longest consecutive occurrence of something, think:
Current streak
Maximum streak
Reset when the condition breaks.
*/

public class FindMaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums){
        int max = 0; 
        int c = 0;
        for(int num : nums){
            if(num==1){
                c++;
                max = Math.max(c, max);
            }
            else
                c=0;
        }
        return max;
    }
}
