package Day5;
/*
APPROACH: Brute Force

1. Iterate through every possible pair of Land ride and Water ride.
2. For each pair, evaluate both possible orders:
      a) Land -> Water
      b) Water -> Land
3. The second ride can start only when:
      - the first ride has finished, and
      - the second ride has opened.
   Therefore:
      startTime = max(firstRideFinishTime, secondRideOpenTime)
4. Compute the final completion time for both orders.
5. Keep track of the minimum completion time across all combinations.

FORMULAS:

Land -> Water:
    landFinish = landStartTime[i] + landDuration[i]
    waterStart = max(landFinish, waterStartTime[j])
    finishTime = waterStart + waterDuration[j]

Water -> Land:
    waterFinish = waterStartTime[j] + waterDuration[j]
    landStart = max(waterFinish, landStartTime[i])
    finishTime = landStart + landDuration[i]

TIME COMPLEXITY:
    O(n * m)

SPACE COMPLEXITY:
    O(1)

where:
    n = number of land rides
    m = number of water rides
*/

public class EarliestFinishTime {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                int landFinish = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finish1 = waterStart + waterDuration[j];

                ans = Math.min(ans, finish1);

                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int finish2 = landStart + landDuration[i];

                ans = Math.min(ans, finish2);
            }
        }
        return ans;
    }
}
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
