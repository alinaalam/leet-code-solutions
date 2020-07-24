/**
* All Paths From Source to Target
* https://leetcode.com/problems/all-paths-from-source-to-target/
*/
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        currentPath.add(0); // starting node
        
        allPaths(allPaths, currentPath, graph, 0);
        
        return allPaths;
    }
    
    private void allPaths(List<List<Integer>> allPaths, List<Integer> currentPath, int[][] graph, int currentNode) {
        // base case
        if (currentNode == graph.length - 1) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        
        for (int nextNode : graph[currentNode]) {
            currentPath.add(nextNode);
            allPaths(allPaths, currentPath, graph, nextNode);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
