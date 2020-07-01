/** 
* Valid Anagram
* https://leetcode.com/problems/valid-anagram/
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        // sanity check
        if (s.length() != t.length()) {
            return false;
        }
            
        Map<Character, Integer> freq = new HashMap<>();
        
        for (char character : s.toCharArray()) {
            int counter = freq.getOrDefault(character, 0);
            freq.put(character, counter + 1);
        }
        
        for (char character : t.toCharArray()) {
            if (!freq.containsKey(character)) {
                return false;
            }
            int counter = freq.get(character);
            freq.put(character, counter - 1);
        }
        
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        
        return true;
    }
}
