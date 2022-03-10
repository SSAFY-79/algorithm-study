package algorithm.yunsik.week3.boj.q20115;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int input;
        int max = 0;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(st.nextToken());
            max = Math.max(max, input);
            sum += input;
        }
        bw.write(String.valueOf(((double)sum + max) / 2));
        bw.flush();
    }
}
