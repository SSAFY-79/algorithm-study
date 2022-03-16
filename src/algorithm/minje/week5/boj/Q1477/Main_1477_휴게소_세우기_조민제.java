package algorithm.minje.week5.boj.Q1477;
/*
메모리 : 11720KB
시간 : 80ms
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1477_휴게소_세우기_조민제 {
    static int N, M, L;
    static int[] diff;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        diff = new int[N + 1];
        int[] loc = new int[N + 2];
        loc[0] = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            loc[i] = Integer.parseInt(st1.nextToken());
        }
        loc[N + 1] = L;

        Arrays.sort(loc);

        //차이구하기
        for (int i = 1; i <= N + 1; i++) {
            diff[i - 1] = loc[i] - loc[i - 1];
        }
        Arrays.sort(diff);

        int left = 1, right = diff[diff.length - 1];
        int ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPassed(mid)) {
                ans = Math.min(ans, mid);
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush(); //왜와이?
    }

    public static boolean isPassed(int mid) {
        int amount = 0;
        for (int i = diff.length - 1; i >= 0; i--) {
            if (diff[i] <= mid) break;
            int dist = diff[i];
            int divisor = 1;
            while (dist > mid) {
                dist = diff[i];
                divisor++;
                if (dist % divisor != 0)
                    dist = dist / divisor + 1;
                else
                    dist = dist / divisor;

            }
            amount += divisor - 1;
        }

        if (amount <= M) return true;
        return false;
    }
}