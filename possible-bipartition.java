/**
* Possible Bipartition
* https://leetcode.com/problems/possible-bipartition/
*/
class Solution {
    
    private List<Integer>[] list;
    private int[] colorArray;
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // fill out the adjacency list
       list = new List[N + 1];
        
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for (int[] enemies : dislikes) {
            list[enemies[0]].add(enemies[1]);
            list[enemies[1]].add(enemies[0]);
        }
        
        // color array
        colorArray = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            colorArray[i] = -1;
        }
        
        for (int i = 1; i <= N; i++) {
            if (colorArray[i] == -1 && !dfs(i, 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs (int person, int color) {
        // this node has been processed yet
        if (colorArray[person] == -1) {
            
            colorArray[person] = color;
            
            for (int enemy : list[person]) {
                // paint other nodes
                if (!dfs(enemy, 1 - color)) {
                    return false;
                }
            }
            
        } else if (colorArray[person] != color) {
            return false;
        }
        return true;
    }
}
