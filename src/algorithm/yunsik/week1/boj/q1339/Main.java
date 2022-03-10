package algorithm.yunsik.week1.boj.q1339;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] values = new int[26][2];
        for (int i = 0; i < 26; i++) {
            values[i][0] = i;
        }

        char[] input;
        for (int i = 0; i < n; i++) {
            input = br.readLine().toCharArray();
            int len = input.length;
            for (int j = 0; j < len; j++) {
                int charIndex = input[j] - 'A';
                values[charIndex][1] += (int) Math.pow(10, len - 1 - j);
            }
        }

        Arrays.sort(values, Comparator.comparingInt(i -> -i[1]));
        int ans = 0;
        for (int i = 0; i < 9; i++) {
            ans += values[i][1] * (9 - i);
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
