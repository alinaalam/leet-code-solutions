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
        
        // store keys in descending order in a priority queue
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) ->
            Integer.compare(map.get(b), map.get(a)) 
        );
        
        queue.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()) {
            char c = queue.remove();
            // for each character, append them according to their frequency
            int frequency = map.get(c);
            for (int i = 0; i < frequency; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
