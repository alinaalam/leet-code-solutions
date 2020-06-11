/**
* Sort Colors
* https://leetcode.com/problems/sort-colors/
*/
class Solution {
    // 0's must go to the left side and 2's must go to the right
    public void sortColors(int[] nums) {
        int leftPointer = 0, rightPointer = nums.length - 1, currentPointer = 0;
        
        while (currentPointer <= rightPointer) {
            int temp = nums[currentPointer];
            if (temp == 0) {
                nums[currentPointer] = nums[leftPointer];
                nums[leftPointer] = temp;
                leftPointer++;
                currentPointer++;
            }
            else if (temp == 2) {
                nums[currentPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
                rightPointer--;
            }
            else {
                currentPointer++;
            }
        }
    }
}
