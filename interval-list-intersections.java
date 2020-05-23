/**
* Interval List Intersections
* https://leetcode.com/problems/interval-list-intersections/
*/
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // sanity check
        if (A.length == 0 || B.length == 0) {
            return new int[][] {};
        }
        
        int pointer1 = 0, pointer2 = 0;
        
        List<Integer[]> result = new ArrayList<>();
        
        while (pointer1 < A.length && pointer2 < B.length) {
            int[] a = A[pointer1];
            int[] b = B[pointer2];
            
            Integer[] temp = new Integer[2];
            boolean start = false;
            boolean end = false;
            
            // check starting interval
            if (b[0] == a[0]) {
                temp[0] = b[0];
                start = true;
            }
            else if (b[0] > a[0] && b[0] <= a[1]) {
                temp[0] = b[0];
                start = true;
            }
            else if (a[0] > b[0] && a[0] <= b[1]) {
                temp[0] = a[0];
                start = true;
            }
            
            // check ending interval
            if (b[1] == a[1]) {
                temp[1] = a[1];
                end = true;
            }
            else if (a[1] < b[1] && a[1] >= b[0]) {
                temp[1] = a[1];
                end = true;
            }
            else if (b[1] < a[1] && b[1] >= a[0]) {
                temp[1] = b[1];
                end = true;
            }
            
            if (start && end) {
                result.add(temp);
            }
            
            if (a[1] <= b[1]) {
                pointer1++;
            }
            if (b[1] <= a[1]) {
                pointer2++;
            }
        }
        
        int[][] f = new int[result.size()][2];
        int i = 0;
        
        for (Integer[] arr : result) {
            int[] temp = new int[] {arr[0], arr[1]};
            f[i] = temp;
            i++;
        }
        
        return f;
    }
}
