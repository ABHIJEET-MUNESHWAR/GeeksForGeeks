class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        backtrack(s, resultList, currentList, 0);
        return resultList;
    }

    public void backtrack(String s, List<List<String>> resultList, List<String> currentList, int index) {
        if (index == s.length()) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        int n = s.length();
        for (int i = index; i < n; i++) {
            if (isPalindrome(s, index, i)) {
                currentList.add(s.substring(index, i + 1));
                backtrack(s, resultList, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}