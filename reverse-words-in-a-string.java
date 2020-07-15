/**
* Reverse Words in a String
*/
class Solution {
    public String reverseWords(String s) {
        // sanity check
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        // get rid of spaces at the start and end
        s = s.trim();
        String[] words = s.split("\\s+");
        
        for (int i = 0; i < words.length / 2; i++) {
            String word = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = word;
        }
        
        return String.join(" ", words);
    }
}
