package algorithm.yunsik.week8.boj.q13398;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int prevSum, prevExSum, sum, exSum, ans;
        int init = Integer.parseInt(st.nextToken());
        prevSum = prevExSum = ans = init;
        for (int i = 1, input; i < n; i++) {
            input = Integer.parseInt(st.nextToken());

            sum = Math.max(prevSum + input, input);
            exSum = Math.max(prevExSum + input, prevSum);

            ans = Math.max(ans, sum);
            ans = Math.max(ans, exSum);

            prevSum = sum;
            prevExSum = exSum;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
