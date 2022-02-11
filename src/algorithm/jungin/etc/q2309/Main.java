package algorithm.jungin.etc.q2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }
        // 모두 더한 값에서 100을 뺀 것과 두 개를 더한 값이 일치하다면 출력
        int sub = sum - 100;
        int temp;
        loop:
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                temp = height[i] + height[j];
                if (temp == sub) {
                    height[i] = -1;
                    height[j] = -1;
                    break loop;
                }
            }
        }
        Arrays.sort(height);
        for (int i = 0; i < 9; i++) {
            if (height[i] != -1)
                System.out.println(height[i]);
        }
    }
}
