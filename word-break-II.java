/**
* Word Break II
* https://leetcode.com/problems/word-break-ii/
*/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       

    // DFS function returns an array including all substrings derived from s.
    private List<String> DFS(String s, List<String> wordDict, Map<String, LinkedList<String>>map) {
        if (map.containsKey(s)) 
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
}
