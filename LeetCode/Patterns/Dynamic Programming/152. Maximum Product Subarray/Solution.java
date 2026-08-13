class Solution {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return nums[0];
        }
        int prefix = 1;
        int suffix = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[size - i - 1];
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
    }
}