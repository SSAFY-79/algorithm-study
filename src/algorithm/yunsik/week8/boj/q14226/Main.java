package algorithm.yunsik.week8.boj.q14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int len = poll[0];
            int clip = poll[1];
            int depth = poll[2];
            if (dp[len][clip] <= depth) continue;
            dp[len][clip] = depth;
            if (len == n) {
                ans = depth;
                break;
            }
            if (len != clip) queue.offer(new int[]{len, len, depth + 1});
            if (clip != 0 && len + clip <= n) queue.offer(new int[]{len + clip, clip, depth + 1});
            if (len > 0) queue.offer(new int[]{len - 1, clip, depth + 1});
        }
        System.out.println(ans);
    }
}
