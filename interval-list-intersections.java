/**
* Interval List Intersections
* https://leetcode.com/problems/interval-list-intersections/
*/
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        List<int[]> result = new ArrayList<>();
        int pointer1 = 0, pointer2 = 0;
        
        while (pointer1 < A.length && pointer2 < B.length) {
            int[] a = A[pointer1];
            int[] b = B[pointer2];
            
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            
            if (a[1] < b[1]) {
                pointer1++;
            }
            else {
                pointer2++;
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
