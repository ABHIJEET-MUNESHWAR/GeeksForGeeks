class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
          if (nums[i] != 0) {
            nums[j++] = nums[i];
          }
        }
        while (j < len) {
          nums[j++] = 0;
        }        
    }
}