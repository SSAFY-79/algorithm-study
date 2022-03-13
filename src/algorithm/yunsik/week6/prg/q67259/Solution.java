package algorithm.yunsik.week6.prg.q67259;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static final int[] dr = {1, 0, -1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int n, m;

    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        queue.offer(new int[]{0, 0, 1, 0});

        int[][][] visitCost = new int[n][m][4];
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int row = index[0];
            int col = index[1];
            int dir = index[2];
            int cost = index[3];

            if (visitCost[row][col][dir] != 0 && visitCost[row][col][dir] <= cost) continue;
            visitCost[row][col][dir] = cost;

            for (int i = -1; i <= 1; i++) {
                int nextDir = (dir + i + 4) % 4;
                int nextR = index[0] + dr[nextDir];
                int nextC = index[1] + dc[nextDir];
                if (isValidRange(nextR, nextC) && board[nextR][nextC] == 0) {
                    if (i == 0) queue.offer(new int[]{nextR, nextC, nextDir, cost + 100});
                    else queue.offer(new int[]{nextR, nextC, nextDir, cost + 600});
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (visitCost[n - 1][m - 1][i] != 0) {
                answer = Math.min(answer, visitCost[n - 1][m - 1][i]);
            }
        }
        return answer;
    }

    private boolean isValidRange(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}