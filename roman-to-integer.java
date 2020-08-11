/**
* Roman to Integer
* https://leetcode.com/problems/roman-to-integer/
*/
class Solution {
    
    private Map<Character, Integer> map = new HashMap<>();
    
    Solution() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    public int romanToInt(String s) {
        int num = map.get(s.charAt(0));
        
        char previous = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            int currentValue = map.get(current);
            
            if (currentValue > map.get(previous)) {
                currentValue -= 2 * map.get(previous);
            }
            
            num += currentValue;
            previous = current;
        }
        
        return num;
    }
}
