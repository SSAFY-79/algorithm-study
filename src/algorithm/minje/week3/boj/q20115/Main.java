package algorithm.minje.week3.boj.q20115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int maxIdx = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] quantList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (max < input) {
                max = input;
                maxIdx = i;
            }
            quantList[i] = input;
        }

        float ans = quantList[maxIdx];
        for (int i = 0; i < quantList.length; i++) {
            if (i == maxIdx) continue;
            ans += quantList[i] / 2.0;
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
    }
}
