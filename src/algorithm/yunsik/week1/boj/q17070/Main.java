package algorithm.yunsik.week1.boj.q17070;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    static int[][] board;
    static int[][][] dp;
    static final int[] tailDx = {0, -1, -1};
    static final int[] tailDy = {-1, -1, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        board = new int[n][];
        dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        boolean block = false;
        for (int i = 0; i < n; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(board[0][i] == 1)
                block = true;
            dp[0][i][0] = block ? 0 : 1;
        }
        dp[0][0][0] = 0;

        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += findCaseCnt(n - 1, n - 1, i);
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int findCaseCnt(int x, int y, int c) {
        if (checkInvalidState(x, y, c)) return 0;
        if (dp[x][y][c] != -1) return dp[x][y][c];

        int result = findCaseCnt(x + tailDx[c], y + tailDy[c], 1);
        if (c == 0) {
            result += findCaseCnt(x, y - 1, c);
        } else if (c == 1) {
            result += findCaseCnt(x - 1, y - 1, 0) + findCaseCnt(x - 1, y - 1, 2);
        } else {
            result += findCaseCnt(x - 1, y, c);
        }
        return dp[x][y][c] = result;
    }

    private static boolean checkInvalidState(int x, int y, int c) {
        if (outRange(x, y) || board[x][y] == 1) return true;
        if (outRange(x + tailDx[c], y + tailDy[c]) || board[x+ tailDx[c]][y+ tailDy[c]] == 1) return true;
        return (c == 1 && (board[x][y-1] == 1 || board[x-1][y] == 1));
    }

    private static boolean outRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}
