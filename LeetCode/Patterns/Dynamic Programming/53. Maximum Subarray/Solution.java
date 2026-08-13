class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = maxSoFar;
        int size = nums.length;
        for (int i = 1; i < size; i++) {
          maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
          maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;        
    }
}