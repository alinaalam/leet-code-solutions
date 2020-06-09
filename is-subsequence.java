/**
* Is Subsequence
* https://leetcode.com/problems/is-subsequence/
*/
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        
        int pointerT = 0, pointerS = 0;
        
        while (pointerT < t.length()) {
            if (t.charAt(pointerT) == s.charAt(pointerS)) {
                pointerS++;
            }
            if (pointerS == s.length()) {
                return true;
            }
            pointerT++;
        }
        
        return false;
    }
}
