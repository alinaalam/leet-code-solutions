/** 
* Two City Scheduling
* https://leetcode.com/problems/two-city-scheduling/
*/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        // find out the cost difference for each person with respect to one city
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] - a[1]) - (b[0] - b[1]);
            } 
        });
        
        int cost = 0;
        
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][0] + costs[costs.length - i - 1][1];
        }
        
        return cost;
    }
}
