/**
* Hamming Distance
* https://leetcode.com/problems/hamming-distance/
*/
class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        
        while (x > 0 || y > 0) {
            count += (x % 2) ^ (y % 2);
            x >>= 1; // x /= 2
            y >>= 1;
        }
        
        return count;
    }
}
