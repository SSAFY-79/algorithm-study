package algorithm.minje.week5.boj.Q3079;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079_입국심사_조민제 {
    static int N, M;
    static int[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        times = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            times[i] = input;
        }

        Arrays.sort(times);

//        long max = times[times.length - 1];
        long left = 1;
//        long right = max * M;
        long right = Integer.MAX_VALUE + 1L;


        /*
        1. times int->long
        2. times * M
        3. right 대입
         */
//        long right = times[times.length - 1] * M;
        /*
        1. times * M int형 계산 범위 안에서
        2.
         */
        long mid = 0;

        System.out.println(right);
        long ans = Long.MAX_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;

            if (isPassed(times, M, mid)) {
                ans = ans > mid ? mid : ans;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean isPassed(int[] times, int n, long mid) {
        long amount = 0;

        for (int i = 0; i < times.length; ++i) {
            amount += mid / times[i];
        }

        if (amount >= n) return true;
        else return false;
    }
}
