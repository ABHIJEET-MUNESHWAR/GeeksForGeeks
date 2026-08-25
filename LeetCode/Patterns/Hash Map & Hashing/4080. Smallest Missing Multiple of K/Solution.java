class Solution {

    public int missingMultiple(int[] nums, int k) {
        boolean[] contains = new boolean[201];

        for (int ele : nums) {
            contains[ele] = true;
        }

        int ans = k;

        while (contains[ans]) {
            ans += k;
        }

        return ans;
    }
}