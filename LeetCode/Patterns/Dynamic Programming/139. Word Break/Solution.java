class Solution {

    HashSet<String> set = new HashSet<String>();

    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return solve(s, 0);
    }

    private boolean solve(String s, int index) {
        if (index >= s.length()) {
            return true;
        }
        if (set.contains(s)) {
            return true;
        }
        for (int endIndex = index + 1; endIndex <= s.length(); endIndex++) {
            String sub = s.substring(index, endIndex);
            if (set.contains(sub) && solve(s, endIndex)) {
                return true;
            }
        }
        return false;
    }
}