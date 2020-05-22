class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            int frequency = map.getOrDefault(c, 0);
            map.put(c, frequency + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        Set<Character> keys = map.keySet();
        
        Collections.sort(keys, new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                return 0;
            }
        });
        
        return sb.toString();
    }
}
