/**
* K Closest Points to Origin
* https://leetcode.com/problems/k-closest-points-to-origin/
*/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // using priority queue with K size
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));
        
        // calculate Euclidean distance for all the points
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > K) {
                maxHeap.remove();
            }
        }
        
        // send back K points
        int[][] result = new int[K][];
        int index = 0;
        
        while (!maxHeap.isEmpty()) {
            result[index] = maxHeap.remove();
            index++;
        }
        
        return result;
    }
}
