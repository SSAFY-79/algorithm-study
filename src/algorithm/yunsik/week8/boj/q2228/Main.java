package algorithm.yunsik.week8.boj.q2228;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[][] dp;
    static int n, m;
    static final int MIN_INF = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        arr[0] = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, m - 1));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int dfs(int cur, int remain) {
        if (remain < 0) return 0;
        if (cur >= n) return MIN_INF;
        if (dp[cur][remain] != Integer.MIN_VALUE) return dp[cur][remain];
        int ret = dfs(cur + 1, remain);
        int next = 2;
        do {
            ret = Math.max(ret, dfs(cur + next, remain - 1));
            next++;
        } while (cur + next <= n);
        return dp[cur][remain] = ret + arr[cur];
    }
}
