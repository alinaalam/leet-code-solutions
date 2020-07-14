/**
* Angle Between Hands of a Clock
* https://leetcode.com/problems/angle-between-hands-of-a-clock/
*/
class Solution {
    public double angleClock(int hour, int minutes) {
        // calculate minutes angle
        double minutesAngle = calculateMinutesAngle(minutes);
        // calculate hour angle
        double hoursAngle = calculateHoursAngle(hour, minutes);
        // calculate difference
        double angle = Math.abs(hoursAngle - minutesAngle);
        if (angle > 180) {
            angle = 360.0 - angle;
        }
        return angle;
    }
    
    private double calculateMinutesAngle(int minutes) {
        return (360 / 60) * minutes;
    }
    
    /*
    * we need to calculate how much the hour hand has moved
    * because of the minutes. On the clock, between 2 numbers,
    * there are 5 minutes and that is how much the hour hand
    * moves according to the minutes hands
    * Ex: 12:00 hours hand at exactly 12
    * Between 12:00 to 12:59, hour hand will move between 12
    * and 1. So, we need to translate that
    * 60 minutes = 5 minutes => 1 min = 5 / 60
    * Also, we need to add the previous minutes starting from 12
    */
    private double calculateHoursAngle(int hour, int minutes) {
        double units = (5.0 / 60) * minutes;
        if (hour > 0 && hour < 12) {
            units += (hour * 5);
        }
        return (360 / 60) * units;
    }
}
