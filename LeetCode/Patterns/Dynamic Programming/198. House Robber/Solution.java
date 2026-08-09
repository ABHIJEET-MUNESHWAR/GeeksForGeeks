class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return solve(nums, n, 0);
    }

    public int solve(int[] nums, int n, int index) {
        if (index >= n) {
            return 0;
        }
        int rob = nums[index] + solve(nums, n, index + 2);
        int skip = solve(nums, n, index + 1);
        return Math.max(rob, skip);
    }
}