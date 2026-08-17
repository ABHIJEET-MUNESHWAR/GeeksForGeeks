class Solution {
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;   
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        if(nums == null) {
            return null;
        }
        int length = nums.length;
        int[] rand = new int[length];
        for(int i=0; i<length; i++){
            int r = (int) (Math.random()*(i+1));
            rand[i] = rand[r];
            rand[r]=nums[i];
        }
        return rand;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */