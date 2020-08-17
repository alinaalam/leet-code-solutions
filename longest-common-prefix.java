/**
* Longest Common Prefix
* https://leetcode.com/problems/longest-common-prefix/
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // find the smallest word first
        Arrays.sort(strs);
        String maximumCommonPrefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            String currentWord = strs[i];
            int j = 0;
            
            for (; j < maximumCommonPrefix.length(); j++) {
                if (maximumCommonPrefix.charAt(j) != currentWord.charAt(j)) {
                    break;
                }
            }
            
            if (j == 0) {
                return "";
            }
            maximumCommonPrefix = maximumCommonPrefix.substring(0, j);
        }
        
        return maximumCommonPrefix;
    }
}
