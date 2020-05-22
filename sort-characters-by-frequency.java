/**
* Sort Characters By Frequency
* https://leetcode.com/problems/sort-characters-by-frequency/
*/
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            int frequency = map.getOrDefault(c, 0);
            map.put(c, frequency + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        List<Character> keys = new ArrayList<>(map.keySet());
        
        // sort keys in decreasing order
        Collections.sort(keys, new Comparator<Character> () {
            @Override
            public int compare(Character key1, Character key2) {
                return Integer.compare(map.get(key2), map.get(key1));
            }
        });
        
        for (Character c : keys) {
            // for each character, append them according to their frequency
            int frequency = map.get(c);
            for (int i = 0; i < frequency; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
