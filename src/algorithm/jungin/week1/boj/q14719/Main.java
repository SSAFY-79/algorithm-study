package algorithm.jungin.week1.boj.q14719;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int block[] = new int[w];
        for (int i = 0; i < w; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for (int i = 1; i < w - 1; i++) {
            int max_left = block[i];
            int max_right = block[i];
            for (int j = 0; j < i; j++) {
                if (block[j] > max_left) {
                    max_left = block[j];
                }
            }
            for (int j = i + 1; j < w; j++) {
                if (block[j] > max_right) {
                    max_right = block[j];
                }
            }
            if (Math.min(max_left, max_right) > block[i]) {
                sum += Math.min(max_left, max_right) - block[i];
            }
        }
        System.out.println(sum);
    }
}
