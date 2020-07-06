/**
* Plus One
* https://leetcode.com/problems/plus-one/
*/
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // if you're here, this means that in the end you've all zeroes
        int[] newArray = new int[digits.length + 1];
        newArray[0] = 1;
        
        return newArray;
    }
}
