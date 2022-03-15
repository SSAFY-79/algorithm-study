package algorithm.yunsik.week2.boj.q1913;

import java.io.*;

public class Main {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans = new StringBuilder();
        int curX = 0, curY = 0, dir = 0, ansX = -1, ansY = -1;
        N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        board = new int[N][N];
        int cur = N * N;
        while (cur > 0) {
            board[curX][curY] = cur;
            if (cur-- == P) {
                ansX = curX + 1;
                ansY = curY + 1;
            }
            if (outRange(curX + dx[dir], curY + dy[dir]) || board[curX + dx[dir]][curY + dy[dir]] != 0) {
                dir = (dir + 1) % 4;
            }
            curX += dx[dir];
            curY += dy[dir];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans.append(board[i][j]).append(" ");
            }
            ans.append("\n");
        }
        ans.append(ansX).append(" ").append(ansY);
        bw.write(ans.toString());
        bw.flush();
    }

    private static boolean outRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}
