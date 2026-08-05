class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] nums, int index, List<Integer> temp) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        solve(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, index + 1, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }
}