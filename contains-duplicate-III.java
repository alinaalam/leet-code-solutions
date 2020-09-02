/**
* Contains Duplicate III
* https://leetcode.com/problems/contains-duplicate-iii/
**/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        
        Map<Long, Long> buckets = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            long wrappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucketId = wrappedNum / ((long)t + 1);
            
            if(buckets.containsKey(bucketId) 
               || (buckets.containsKey(bucketId-1) && wrappedNum - buckets.get(bucketId-1) <= t)
               || (buckets.containsKey(bucketId+1) && buckets.get(bucketId+1) - wrappedNum <= t))
                return true;
            
            if(buckets.size() == k){
                long outdatedBucket = ((long)nums[i-k] - Integer.MIN_VALUE) / ((long)t + 1);
                buckets.remove(outdatedBucket);
            }
            
            buckets.put(bucketId, wrappedNum);
        }
        
        return false;
    }
}
