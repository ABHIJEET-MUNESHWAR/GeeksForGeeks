class NumArray {
    
    int[] sums;

    public NumArray(int[] nums) {
        if(nums == null || nums.length==0){
            return;
        }
        int size = nums.length;
        sums = new int[size+1];
        for(int i=1; i<=size; i++){
            sums[i] = sums[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left<0 || right > sums.length-1 || left > right){
            return Integer.MIN_VALUE;
        }
        return sums[right+1] - sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */