package algorithm.yunsik.week4.boj.q1261;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int n, m;

    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int[][] breakCost = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(breakCost[i], Integer.MAX_VALUE);
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[2] >= breakCost[poll[0]][poll[1]]) continue;
            breakCost[poll[0]][poll[1]]  = poll[2];
            for (int i = 0; i < 4; i++) {
                int px = poll[0] + dx[i];
                int py = poll[1] + dy[i];
                if (!isValidRange(px, py)) continue;
                queue.offer(new int[]{px, py, poll[2] + board[px][py] - '0'});
            }
        }
        return breakCost[n - 1][m - 1];
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
