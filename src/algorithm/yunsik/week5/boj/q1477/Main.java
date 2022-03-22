package algorithm.yunsik.week5.boj.q1477;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] location;
    static int N, M, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        location = new boolean[L + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            location[Integer.parseInt(st.nextToken())] = true;
        }

        int begin = 1;
        int end = L;
        int mid;
        while (begin < end) {
            // mid = 휴게소가 없는 구간의 최대 거리
            mid = (begin + end) / 2;
            if (isValidTerm(mid)) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();
    }

    private static boolean isValidTerm(int mid) {
        int cur = 0;
        int cnt = 0;
        for (int i = 0; i <= L; i++) {
            if (i - cur > mid) {
                cur = i - 1;
                if (++cnt > M) return false;
            }
            if (location[i]) cur = i;
        }
        return true;
    }
}
