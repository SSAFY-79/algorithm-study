package algorithm.yunsik.week1.boj.q2482;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    static final int mod = 1000000003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][1] = i;
        }

        int ans;
        if(k == 1) ans = n;
        else ans = (getDP(n - 3, k - 1) + getDP(n - 1, k)) % mod;
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int getDP(int n, int k) {
        if (k > n / 2 + 1) return 0;
        if (dp[n][k] != -1) return dp[n][k];
        return dp[n][k] = (getDP(n - 2, k - 1) + getDP(n - 1, k)) % mod;
    }
}
