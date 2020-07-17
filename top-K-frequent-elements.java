/**
* Top K Frequent Elements
* https://leetcode.com/problems/top-k-frequent-elements/
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maximumFreq = 0;
        
        // get the frequencies
        for (int num : nums) {
            int frequency = map.getOrDefault(num, 0) + 1;
            map.put(num, frequency);
            maximumFreq = Math.max(maximumFreq, frequency);
        }
        
        // initialize buckets
        List<Integer>[] buckets = new List[maximumFreq + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // store frequencies in respective buckets
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        
        // gather results
        int[] frequentNumbers = new int[k];
        
        for (int i = buckets.length - 1, j = 0; i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            for (int number : bucket) {
                if (j == frequentNumbers.length) {
                    break;
                }
                frequentNumbers[j] = number;
                j++;
            }
        }
        
        return frequentNumbers;
    }
}
