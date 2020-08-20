/**
* Length of Last Word
* https://leetcode.com/problems/length-of-last-word/
*/
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        char[] characters = s.toCharArray();
        
        for (int i = characters.length - 1; i >= 0; i--) {
            if (characters[i] == ' ') {
                return characters.length - i - 1;
            }
        }
        
        return characters.length;
    }
}
