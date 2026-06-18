package Day15_25;
/*
LeetCode 1344: Angle Between Hands of a Clock

Pattern:
- Math + Geometry

Idea:
- Hour hand moves:
      30° per hour
      0.5° per minute
- Minute hand moves:
      6° per minute

Formula:
hourAngle   = hour * 30 + minutes * 0.5
minuteAngle = minutes * 6

angle = |hourAngle - minuteAngle|

Since the smaller angle is required:
angle = min(angle, 360 - angle)

Example:
hour = 3, minutes = 30

hourAngle   = 3*30 + 30*0.5 = 105°
minuteAngle = 30*6 = 180°

angle = |105 - 180| = 75°

Answer = 75°

Time Complexity: O(1)
Space Complexity: O(1)

Key Insight:
The hour hand does NOT stay fixed between hours.
It moves continuously by 0.5° every minute.

Important:
If hour == 12, treat it as 0:
hour %= 12;
*/
public class AngleClock {
    public double angleClock(int hour, int min){
        if(hour ==12)
                hour =0;
        double angle = Math.abs(hour*30+min*0.5 - min*6);
        return Math.min(angle, 360 - angle);
    }
}
