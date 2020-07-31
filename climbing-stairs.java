/**
* Climbing Stairs
* https://leetcode.com/problems/climbing-stairs/
*/
class Solution {
    public int climbStairs(int n) {
        List<List<Integer>> paths = new ArrayList<>();
		generatePossiblePaths(0, n, new ArrayList<Integer>(), paths);
        return paths.size();
    }
    
    private static void generatePossiblePaths(int step, int steps, List<Integer> path, List<List<Integer>> paths) {
		List<Integer> newPath = new ArrayList<>(path);
		newPath.add(step);
		
		if (step == steps) {
			paths.add(newPath);
			return;
		}
		
		if (step + 1 <= steps) {
			generatePossiblePaths(step + 1, steps, newPath, paths);
		}
		if (step + 2 <= steps) {
			generatePossiblePaths(step + 2, steps, newPath, paths);
		}
	}
}
