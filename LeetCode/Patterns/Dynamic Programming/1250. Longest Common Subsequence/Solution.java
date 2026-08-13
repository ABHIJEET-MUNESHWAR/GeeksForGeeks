class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return solve(text1, text2, 0, 0);
    }

    private int solve(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));
        }
    }
}