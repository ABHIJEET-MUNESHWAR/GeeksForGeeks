class Solution {
    public boolean containsDuplicate(int[] nums) {        
        Set<Integer> integerSet = new HashSet<>();
        for (Integer num : nums) {
          integerSet.add(num);
        }
        return integerSet.size() != nums.length;
    }
}