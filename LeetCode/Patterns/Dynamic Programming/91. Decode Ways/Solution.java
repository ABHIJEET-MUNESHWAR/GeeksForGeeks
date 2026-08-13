class Solution {
    public int numDecodings(String s) {
        int size = s.length();
        return solve(s, 0, size);
    }

    private int solve(String s, int index, int size) {
        if (index == size) {
            return 1; // Found 1 valid split
        }
        if (s.charAt(index) == '0') {
            return 0; // Not possible to split
        }
        int onlyIthChar = solve(s, index + 1, size);
        int ithAndIthPlusOneChar = 0;
        if ((index + 1) < size) {
            if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index + 1) <= '6')) {
                ithAndIthPlusOneChar = solve(s, index + 2, size);
            }
        }
        return ithAndIthPlusOneChar + onlyIthChar;
    }
}