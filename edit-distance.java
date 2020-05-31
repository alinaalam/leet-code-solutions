/**
* Edit Distance
* https://leetcode.com/problems/edit-distance/
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1, n = word2.length() + 1;
        int[][] result = new int[m][n];
        
        // first row
        for (int i = 0; i < m; i++) {
            result[i][0] = i;
        }
        
        // first col
        for (int i = 0; i < n; i++) {
            result[0][i] = i;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                    continue;
                }
                // get minimum of all the neighbours and then add 1 
                result[i][j] = Math.min(result[i - 1][j], Math.min(result[i][j - 1], result[i - 1][j - 1])) + 1;
                
            }
        }
        
        return result[m - 1][n - 1];
    }
}
