package algorithm.jungin.etc.q2491;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int max = 1;    // n이 1일 때

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 증가
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                count += 1;
                max = Math.max(max, count);
            } else
                count = 1;
        }
        // 감소
        count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1]) {
                count += 1;
                max = Math.max(max, count);
            } else
                count = 1;
        }
        System.out.println(max);
    }
}