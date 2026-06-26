package Day1_14;
/*
You are given two categories of theme park attractions: land rides and water rides.

Land rides
landStartTime[i] – the earliest time the ith land ride can be boarded.
landDuration[i] – how long the ith land ride lasts.
Water rides
waterStartTime[j] – the earliest time the jth water ride can be boarded.
waterDuration[j] – how long the jth water ride lasts.
A tourist must experience exactly one ride from each category, in either order.

A ride may be started at its opening time or any later moment.
If a ride is started at time t, it finishes at time t + duration.
Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it opens.
Return the earliest possible time at which the tourist can finish both rides.
*/

/*
APPROACH: 

1. Assume rides are taken in a fixed order:
      First Category -> Second Category

2. Find the earliest possible finishing time among all rides
   in the first category:
      finish1 = min(start1[i] + duration1[i])

3. Once the first ride is finished at finish1, try every ride
   in the second category:
      - If the ride is already open, start immediately.
      - Otherwise, wait until it opens.

   startTime = max(finish1, start2[i])

4. Compute the finishing time for each second-category ride:
      finishTime = startTime + duration2[i]

5. Take the minimum finishing time among all such choices.

6. Run the same logic for:
      Land -> Water
      Water -> Land

7. Return the smaller of the two results.

FORMULAS:

First Ride Finish:
    finish1 = start1[i] + duration1[i]

Second Ride Start:
    startTime = max(finish1, start2[j])

Final Finish:
    startTime + duration2[j]

TIME COMPLEXITY:
    O(n + m)

SPACE COMPLEXITY:
    O(1)

where:
    n = number of rides in first category
    m = number of rides in second category
*/
public class EarliestFinishTimeII {
    public static int solve(int[] st1, int[] dur1, int[] st2, int[] dur2){
        int fin1 = Integer.MAX_VALUE;
        int fin2 = Integer.MAX_VALUE;

        for(int i=0; i<st1.length; i++){
            fin1 = Math.min(fin1, st1[i] + dur1[i]);
        }
        for(int i=0; i<st2.length; i++){
            fin2 = Math.min(Math.max(fin1, st2[i])+ dur2[i], fin2 );
        }
        return fin2;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int lFirst = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int wFirst = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(lFirst, wFirst);
    }
}
