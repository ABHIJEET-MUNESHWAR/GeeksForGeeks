class Solution {

    public int rob(int[] nums) {
        int size = nums.length;
        int prevPrev = 0;
        int prev = nums[0];
        for (int i = 2; i <= size; i++) {
            int steal = nums[i - 1] + prevPrev;
            int skip = prev;
            int temp = Math.max(steal, skip);
            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }
}