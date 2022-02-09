package algorithm.yunsik.week2.boj.q14467;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] cowPosition = new int[11];
        int a, b, ans = 0;
        Arrays.fill(cowPosition, -1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (cowPosition[a] == -1) {
                cowPosition[a] = b;
            } else if (cowPosition[a] != b) {
                cowPosition[a] = b;
                ans++;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
