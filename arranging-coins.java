/**
* Arranging Coins
* https://leetcode.com/problems/arranging-coins/
*/
class Solution {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        
        while (left <= right) {
            long row = left + (right - left) / 2;
            long coins = row * (row + 1) / 2;
            
            if (coins == n) {
                return (int) row;
            }
            
            if (n < coins) {
                right = row - 1;
            }
            else {
                left = row + 1;
            }
        }
        
        return (int) right;
    }
}
