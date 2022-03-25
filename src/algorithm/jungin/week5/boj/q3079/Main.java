package algorithm.jungin.week5.boj.q3079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] time = new int[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, time[i]);
        }
        long start = 0, end = max * M, mid, total;
        // 이런 문제 말고.. 비슷한 유형
        while (start < end) {
            total = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                total += mid / time[i];
            }
            if (total >= M)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println(end);
    }
}