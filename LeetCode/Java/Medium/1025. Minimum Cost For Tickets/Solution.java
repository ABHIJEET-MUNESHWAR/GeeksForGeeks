class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return solveRecursion(days, costs, 0);
    }

    private int solveRecursion(int[] days, int[] costs, int index) {
        if (index >= days.length) {
            return 0;
        }
        int costOfOneDayPass = costs[0] + solveRecursion(days, costs, index + 1);
        int costOfSevenDayPass = costs[1]
                + solveRecursion(days, costs, getIndexOfNextDay(days, index, days[index] + 7));
        int costOfThirtyDayPass = costs[2]
                + solveRecursion(days, costs, getIndexOfNextDay(days, index, days[index] + 30));
        return Math.min(costOfOneDayPass, Math.min(costOfSevenDayPass, costOfThirtyDayPass));
    }

    private int getIndexOfNextDay(int[] days, int index, int totalDaysCanBeCovered) {
        while (index < days.length && days[index] < totalDaysCanBeCovered) {
            index++;
        }
        return index;
    }
}