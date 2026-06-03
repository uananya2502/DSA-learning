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
