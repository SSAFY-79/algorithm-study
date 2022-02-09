package algorithm.jungin.week1.boj.q5557;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.parseInt(st.nextToken());

        long dp[][] = new long[n][21];
        dp[0][number[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    if (j + number[i] <= 20) {
                        dp[i][j + number[i]] += dp[i - 1][j];
                    }
                    if (j - number[i] >= 0 ) {
                        dp[i][j - number[i]] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n - 2][result]);
    }
}
