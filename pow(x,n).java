/**
* Pow(x, n)
* https://leetcode.com/problems/powx-n/
*/
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MIN_VALUE + 2;
            } else {
                n = -n;
                x = 1/x;
            }
        }
        return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
    }
}
