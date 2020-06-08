/**
* Power of Two
* https://leetcode.com/problems/power-of-two/
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        long pow = 1;
        
        while (pow < n) {
            pow *= 2;
        }
        
        return pow == n;
    }
}
