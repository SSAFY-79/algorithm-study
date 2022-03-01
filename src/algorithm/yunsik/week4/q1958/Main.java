package algorithm.yunsik.week4.q1958;

import java.io.*;

public class Main {
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String one = br.readLine();
        String two = br.readLine();
        String three = br.readLine();

        int oneLen = one.length();
        int twoLen = two.length();
        int threeLen = three.length();

        dp = new int[oneLen + 1][twoLen + 1][threeLen + 1];
        for (int i = 1; i <= oneLen; i++) {
            char oneChar = one.charAt(i - 1);
            for (int j = 1; j <= twoLen; j++) {
                char twoChar = two.charAt(j - 1);
                for (int k = 1; k <= threeLen; k++) {
                    char threeChar = three.charAt(k - 1);
                    if (oneChar == twoChar && twoChar == threeChar) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    }
                }
            }
        }
        bw.write(String.valueOf(dp[oneLen][twoLen][threeLen]));
        bw.flush();
    }
}
