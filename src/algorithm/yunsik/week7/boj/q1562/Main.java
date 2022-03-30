package algorithm.yunsik.week7.boj.q1562;

import java.io.*;

public class Main {

    public static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        // depth, num, status
        int[][][] dp = new int[n][10][1 << 10];
        for (int i = 1; i < 10; i++) {
            dp[0][i][1 << i] = 1;
        }
        for (int depth = 1; depth < n; depth++) {
            for (int num = 0; num < 10; num++) {
                for (int status = 0; status < (1 << 10); status++) {
                    if (num > 0) {
                        dp[depth][num][status | 1 << num] += dp[depth - 1][num - 1][status];
                        dp[depth][num][status | 1 << num] %= MOD;
                    }
                    if (num < 9) {
                        dp[depth][num][status | 1 << num] += dp[depth - 1][num + 1][status];
                        dp[depth][num][status | 1 << num] %= MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[n - 1][i][(1 << 10) - 1];
            ans %= MOD;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
