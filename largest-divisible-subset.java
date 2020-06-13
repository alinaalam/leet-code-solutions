/**
* Largest Divisible Subset
* https://leetcode.com/problems/largest-divisible-subset/
*/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] result = new int[nums.length];
        int[] previousIndices = new int[nums.length];
        
        Arrays.sort(nums);
        
        int max = 0;
        int index = -1;
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            previousIndices[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                    previousIndices[i] = j;
                }
            }
            if (result[i] > max) {
                max = result[i];
                index = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = previousIndices[index];
        }
        
        return res;
    }
}
