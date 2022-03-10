package algorithm.jungin.etc.q1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        for (int j = N; j >= 0; j--) {
            // 1 << j : 1을 j칸씩 왼쪽으로 옮긴다.
            if ((X & 1 << j) > 0) {
                X -= X & 1 << j;
                count += 1;
            }
        }
        System.out.println(count);
    }
}

