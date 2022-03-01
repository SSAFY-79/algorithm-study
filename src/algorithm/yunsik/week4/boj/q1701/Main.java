package algorithm.yunsik.week4.boj.q1701;

import java.io.*;
import java.util.Arrays;

public class Main {
    static String input;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = br.readLine();
        len = input.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, getMaxPi(input.substring(i), i));
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int getMaxPi(String chars, int begin) {
        int[] pi = new int[len - begin];
        for (int i = 1, j = 0; i < len - begin; i++) {
            while (j > 0 && chars.charAt(i) != chars.charAt(j))
                j = pi[j - 1];
            if (chars.charAt(i) == chars.charAt(j))
                pi[i] = ++j;
        }
        return Arrays.stream(pi).max().orElse(0);
    }
}
