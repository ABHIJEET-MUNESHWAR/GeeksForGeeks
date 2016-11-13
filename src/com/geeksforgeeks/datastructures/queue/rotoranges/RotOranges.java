package com.geeksforgeeks.datastructures.queue.rotoranges;

/**
 * Created using IntelliJ IDEA.
 * User: Abhijeet
 * Date: 12/11/16
 * Time: 7:01 PM
 * http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
 */

import java.util.*;

public class RotOranges {
    static final int R = 3, C = 5;

    class Oranges {
        int x, y;

        Oranges(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValidCell(int i, int j) {
        return ((i >= 0) && (j >= 0) && (i < R) && (j < C));
    }

    private boolean isDelimiter(Oranges orange) {
        return (orange.x == -1 && orange.y == -1);
    }

    private boolean isFreshExists(int[][] input) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private int countDaysToRotOranges(int[][] input) {
        LinkedList<Oranges> queue = new LinkedList<Oranges>();
        int time = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (input[i][j] == 2) {
                    queue.add(new Oranges(i, j));
                }
            }
        }
        queue.add(new Oranges(-1, -1));
        while (!queue.isEmpty()) {
            boolean isRotten = false;
            Oranges orange = queue.poll();
            while (!isDelimiter(orange)) {
                if ((isValidCell(orange.x + 1, orange.y)) && (input[orange.x + 1][orange.y] == 1)) {
                    if (!isRotten) {
                        isRotten = true;
                        time++;
                    }
                    input[orange.x + 1][orange.y] = 2;
                    orange.x++;
                    queue.add(new Oranges(orange.x, orange.y));
                    orange.x--;
                }
                if ((isValidCell(orange.x - 1, orange.y)) && (input[orange.x - 1][orange.y] == 1)) {
                    if (!isRotten) {
                        isRotten = true;
                    }
                    input[orange.x - 1][orange.y] = 2;
                    orange.x--;
                    queue.add(new Oranges(orange.x, orange.y));
                    orange.x++;
                }
                if ((isValidCell(orange.x, orange.y + 1)) && (input[orange.x][orange.y + 1] == 1)) {
                    if (!isRotten) {
                        isRotten = true;
                    }
                    input[orange.x][orange.y + 1] = 2;
                    orange.y++;
                    queue.add(new Oranges(orange.x, orange.y + 1));
                    orange.y--;
                }
                if ((isValidCell(orange.x, orange.y - 1)) && (input[orange.x][orange.y - 1] == 1)) {
                    if (!isRotten) {
                        isRotten = true;
                    }
                    input[orange.x][orange.y - 1] = 1;
                    orange.y--;
                    queue.add(new Oranges(orange.x, orange.y - 1));
                    orange.y++;
                }
                orange = queue.poll();
            }
            if (!queue.isEmpty()) {
                queue.add(new Oranges(-1, -1));
            }
        }
        if (isFreshExists(input)) {
            return -1;
        } else {
            return time;
        }
    }

    public static void main(String[] args) {
        RotOranges rotOranges = new RotOranges();
        int[][] input = new int[][]{{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = rotOranges.countDaysToRotOranges(input);
        if (ans == -1) {
            System.out.println("Oranges can't be rotten");
        } else {
            System.out.println("All oranges will be rotten in " + ans + " days.");
        }
    }
}
