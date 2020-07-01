/**
* Maximum Subarray
* https://leetcode.com/problems/maximum-subarray/
*/
class Solution {
    public int maxSubArray(int[] nums) {
        // sanity check
        if (nums.length == 0) {
            return 0;
        }
        
        int largestSum = nums[0], temp = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            largestSum = Math.max(temp, largestSum);
        }
        
        return largestSum;
    }
}
