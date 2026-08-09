class Solution {
    public int rob(int[] nums) {
        return solve(nums, 0);
    }

    private int solve(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int steal = nums[index] + solve(nums, index + 2);
        int skip = solve(nums, index + 1);
        return Math.max(steal, skip);
    }
}