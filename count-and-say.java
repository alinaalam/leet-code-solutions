/**
* Count and Say
* https://leetcode.com/problems/count-and-say/
*/
class Solution {
    public String countAndSay(int n) {
        int start = 1;
        String result = "1";
        
        while (++start <= n) {
            StringBuilder temp = new StringBuilder();
    
            for (int i = 0; i < result.length(); i++) {
                int count = 1;
                while (i + 1 < result.length() && 
                      result.charAt(i) == result.charAt(i + 1)) {
                    count++;
                    i++;
                }
                temp.append(count);
                temp.append(result.charAt(i));
            }
            
            result = temp.toString();
        }
        
        return result;
    }
}
