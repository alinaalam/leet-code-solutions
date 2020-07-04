/**
* Ugly Number II
* https://leetcode.com/problems/ugly-number-II/
*/
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n];
        int factor2 = 0, factor3 = 0, factor5 = 0;
            
        uglyNumbers[0] = 1;
        
        for (int i = 1; i < n; i++) {
            uglyNumbers[i] = Math.min(Math.min(uglyNumbers[factor2] * 2, uglyNumbers[factor3] * 3), 
                              uglyNumbers[factor5] * 5);
            if (uglyNumbers[i] == uglyNumbers[factor2] * 2) {
                factor2++;
            }
            if (uglyNumbers[i] == uglyNumbers[factor3] * 3) {
                factor3++;
            }
            if (uglyNumbers[i] == uglyNumbers[factor5] * 5) {
                factor5++;
            }
        }
        
        return uglyNumbers[n - 1];
    }
}
