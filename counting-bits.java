/**
* Counting Bits
* https://leetcode.com/problems/counting-bits/
*/
class Solution {
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        
        for (int i = 1; i <= num; i++) {
            arr[i] = arr[i / 2];
            if (i % 2 != 0) {
                arr[i]++; 
            }
        }
        
        return arr;
    }
}
