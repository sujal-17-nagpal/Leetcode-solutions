class Solution {
    public double angleClock(int hour, int minutes) {
        double h = 30*hour + (minutes/2.0);
        double m = 6*minutes;
        double ans = Math.abs(h-m);
        return Math.min(ans,360-ans);
    }
}