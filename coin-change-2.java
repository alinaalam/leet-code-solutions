/**
* Coin Change 2
* https://leetcode.com/problems/coin-change-2/
*/
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        // fill in the first col
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= coins.length; i++) {
            int currentCoin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (currentCoin <= j) {
                    dp[i][j] += dp[i][j - currentCoin];
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}
