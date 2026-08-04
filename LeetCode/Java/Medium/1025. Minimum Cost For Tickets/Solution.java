class Solution {
    int[] dp = new int[366];

    public int solve(int[] days, int[] costs, int n, int index) {
        if (index >= n) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int costOf1DayPass = costs[0] + solve(days, costs, n, index + 1);
        int costOf7DayPass = costs[1] + solve(days, costs, n, getIndexOfNextDay(days, index, days[index] + 7));
        int costOf30DayPass = costs[2] + solve(days, costs, n, getIndexOfNextDay(days, index, days[index] + 30));
        return dp[index] = Math.min(costOf1DayPass, Math.min(costOf7DayPass, costOf30DayPass));
    }

    public int getIndexOfNextDay(int[] days, int index, int totalDaysCanBeCovered) {
        while (index < days.length && days[index] < totalDaysCanBeCovered) {
            index++;
        }
        return index;
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Arrays.fill(dp, -1);
        return solve(days, costs, n, 0);
    }
}