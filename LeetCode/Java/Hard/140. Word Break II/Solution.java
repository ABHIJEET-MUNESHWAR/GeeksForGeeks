class Solution {

    Set<String> set = new HashSet<>();
    Map<String, List<String>> dpMap = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return solveWordBreakTwo(s);
    }

    private List<String> solveWordBreakTwo(String s) {
        if (s.isEmpty()) {
            return Arrays.asList("");
        }
        if (dpMap.containsKey(s)) {
            return dpMap.get(s);
        }
        List<String> result = new ArrayList<>();
        for (int l = 1; l <= s.length(); l++) {
            String currentWord = s.substring(0, l);
            if (set.contains(currentWord)) {
                String remainingWord = s.substring(l);
                List<String> remainingResult = solveWordBreakTwo(remainingWord);
                for (String word : remainingResult) {
                    String toAdd = currentWord + (word.isEmpty() ? "" : " ") + word;
                    result.add(toAdd);
                }
            }
        }
        dpMap.put(s, result);
        return result;
    }
}