/**
 * Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
class Solution {
    /* if the last digit is less than the first one,
     then it means the min exists somewhere in the middle
     otherwise, it's the first one
    */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int firstPointer = 0, secondPointer = nums.length - 1;
        
        if (nums[firstPointer] < nums[secondPointer]) {
            return nums[firstPointer];
        }
        
        // the min exists in the middle
        int min = nums[secondPointer];
        secondPointer--;
        
        while (secondPointer >= 0) {
            min = Math.min(min, nums[secondPointer]);
            secondPointer--;
        }
        
        return min;
    }
}
