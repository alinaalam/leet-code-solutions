/**
* Find the Duplicate Number
* https://leetcode.com/problems/find-the-duplicate-number/
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];
        
        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (slowPointer != fastPointer);
        
        
        int onePointer = nums[0];
        int secondPointer = slowPointer;
        
        while (onePointer != secondPointer) {
            onePointer = nums[onePointer];
            secondPointer = nums[secondPointer];
        }
        
        return onePointer;
    }
}
