/**
* Find the Town Judge
* https://leetcode.com/problems/find-the-town-judge/
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] map = new int[N + 1];
        
        for (int[] t : trust) {
            map[t[0]]--;
            map[t[1]]++;
        }
        
        for (int i = 1; i <= N; i++) {
            if (map[i] == N - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
