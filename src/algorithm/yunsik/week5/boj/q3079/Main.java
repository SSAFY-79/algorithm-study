package algorithm.yunsik.week5.boj.q3079;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        times = new int[n];
        int maxTime = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        long begin = 0L;
        long mid;
        long end = (long) maxTime * m;

        while (begin < end) {
            mid = begin + (end - begin) / 2;
            long availPeople = calcAvailPeople(mid);
            if (availPeople < m) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();
    }

    private static long calcAvailPeople(long mid) {
        long ret = 0L;
        for (int time : times) {
            ret += mid / time;
        }
        return ret;
    }
}
