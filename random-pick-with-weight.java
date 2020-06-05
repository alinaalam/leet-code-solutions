/**
* Random Pick with Weight
* https://leetcode.com/problems/random-pick-with-weight/
*/
class Solution {

    private int[] arr;
    private Random random = new Random();
    private int totalSum = 0;
    
    public Solution(int[] w) {
        arr = new int[w.length];
        
        for (int i = 0; i < w.length; i++) {
            int currentValue = w[i];
            totalSum += currentValue;
            arr[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        int value = random.nextInt(totalSum) + 1;
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (value > arr[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
