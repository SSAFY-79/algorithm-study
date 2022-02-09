package algorithm.yunsik.week1.boj.q5557;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[][] dp = new long[N - 1][21];

        dp[0][inputs[0]] = 1L;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i][j] > 0) {
                    if (j - inputs[i + 1] >= 0)
                        dp[i + 1][j - inputs[i + 1]] += dp[i][j];
                    if (j + inputs[i + 1] <= 20)
                        dp[i + 1][j + inputs[i + 1]] += dp[i][j];
                }
            }
        }
        bw.write(dp[N - 2][inputs[N - 1]] + "\n");
        bw.flush();
    }
}
