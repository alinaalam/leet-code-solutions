/**
* Maximum Sum Circular Subarray
* https://leetcode.com/problems/maximum-sum-circular-subarray/
*/

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        
        // the idea here is that the maxSum = totalSum - minSum
        // if there is no minSum, then the maxSum would just be the totalSum
        
        int totalSum = 0, maxSum = A[0], currMaxSum = 0, minSum = A[0], currMinSum = 0;
        
        for (int curr : A) {
            // calculate max sum
            currMaxSum = Math.max(currMaxSum + curr, curr);
            maxSum = Math.max(maxSum, currMaxSum);
            
            // calculate min sum
            currMinSum = Math.min(currMinSum + curr, curr);
            minSum = Math.min(minSum, currMinSum);
            
            totalSum += curr;
        }
        
        // formula: totalSum = maxSum + minSum => maxSum = totalSum - minSum
        // one caveat: maxSum needs to be greater than 0 
        return (maxSum > 0) ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
}
