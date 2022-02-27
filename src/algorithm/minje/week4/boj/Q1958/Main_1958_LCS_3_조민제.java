package algorithm.minje.week4.boj.Q1958;
/*
메모리 : 17176KB
시간 : 124ms
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1958_LCS_3_조민제 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] stringList = new char[3][];

        for (int i = 0; i < 3; i++) {
            stringList[i] = br.readLine().toCharArray();
        }
        int F = stringList[0].length;
        int S = stringList[1].length;
        int T = stringList[2].length;

        int[][][] dp = new int[F + 1][S + 1][T + 1];

        for (int i = 1; i <= F; i++) {
            for (int j = 1; j <= S; j++) {
                for (int k = 1; k <= T; k++) {
                    if (stringList[0][i - 1] == stringList[1][j - 1] && stringList[0][i - 1] == stringList[2][k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        continue;
                    }
                    dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);

                }
            }
        }

        System.out.println(dp[F][S][T]);
    }
}
