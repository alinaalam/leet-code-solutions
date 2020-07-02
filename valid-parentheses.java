/**
* Valid Parentheses
* https://leetcode.com/problems/valid-parentheses/
*/
class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new LinkedList<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char opening = getOpeningBracket(c);
                if (stack.remove(stack.size() - 1) != opening) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private char getOpeningBracket(char c) {
        char opening = 0;
            switch (c) {
                case ')':
                    opening = '(';
                    break;
                case '}':
                    opening = '{';
                    break;
                case ']':
                    opening = '[';
                    break;
            }
        return opening;
    }
}
