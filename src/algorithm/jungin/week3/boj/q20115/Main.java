package algorithm.jungin.week3.boj.q20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max = 0;
    static double total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        double[] amount = new double[N];
        for (int i = 0; i < N; i++) {
            amount[i] = Double.parseDouble(st.nextToken());
            if (amount[i] > amount[max])
                max = i;
        }
        for (int i = 0; i < N; i++) {
            if (max == i) {
                total += amount[i];
                continue;
            }
            total += amount[i] / 2;
        }
        System.out.println(total);
    }
}