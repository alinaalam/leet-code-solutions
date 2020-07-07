/**
* Island Perimeter
* https://leetcode.com/problems/island-perimeter/
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // this box is an island
                    perimeter += 4;
                    // check top has another island box
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    // check left has another island box
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        
        return perimeter;
    }
}
