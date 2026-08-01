class Solution {
    int result = Integer.MIN_VALUE;

    public int maximumRequests(int n, int[][] requests) {
        int[] resultant = new int[n];
        backtrack(n, requests, resultant, 0, 0);
        return result;
    }

    public void backtrack(int n, int[][] requests, int[] resultant, int index, int count) {
        int m = requests.length;
        if (index >= n) {
            boolean allZero = true;
            for (int r : resultant) {
                if (r != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                result = Math.max(result, count);
            }
            return;
        }
        int from = requests[index][0];
        int to = requests[index][1];
        resultant[from]--;
        resultant[to]++;
        backtrack(n, requests, resultant, index + 1, count + 1);

        resultant[from]++;
        resultant[to]--;
        backtrack(n, requests, resultant, index + 1, count);

    }
}