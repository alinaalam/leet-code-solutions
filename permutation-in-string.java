/**
* Permutation in String
* https://leetcode.com/problems/permutation-in-string/
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // sanity check
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1Array = new int[26];
        int[] s2Array = new int[26];
        
        // fill in both the arrays till the length of s1
        for (int i = 0; i < s1.length(); i++) {
            s1Array[s1.charAt(i) - 'a']++;
            s2Array[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (isMatch(s1Array, s2Array)) {
                return true;
            }
            s2Array[s2.charAt(i) - 'a']--;
            s2Array[s2.charAt(i + s1.length()) - 'a']++;
        }
        
        return isMatch(s1Array, s2Array);
    }
    
    private boolean isMatch(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }
}
