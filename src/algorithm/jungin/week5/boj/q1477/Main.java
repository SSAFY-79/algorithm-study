package algorithm.jungin.week5.boj.q1477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, restArea[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        restArea = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        restArea[0] = 0;
        restArea[N + 1] = L;
        for (int i = 1; i <= N; i++) {
            restArea[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(restArea);
        int start = 1, end = L, mid, min = L;
        while (start < end) {
            int count = 0;
            mid = (start + end) / 2;
            for (int i = 1; i <= N + 1; i++) {
                count += (restArea[i] - (restArea[i - 1] + 1)) / mid;
            }
            if (count > M) {
                start = mid + 1;
            } else {
                min = Math.min(min, mid);
                end = mid;
            }
        }
        System.out.println(min);
    }
}
