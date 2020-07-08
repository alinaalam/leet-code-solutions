/**
* 3Sum
* https://leetcode.com/problems/3sum/
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] > sum) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        
        return list;
    }
}
