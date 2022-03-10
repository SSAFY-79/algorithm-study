package algorithm.yunsik.week3.boj.q20365;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        int cnt = 1;
        char startColor = input[0];
        char currentColor = input[0];

        for (int idx = 0; idx < n; idx++) {
            while (idx < n && input[idx] == currentColor) idx++;
            if (idx < n && currentColor == startColor) cnt++;
            currentColor = (char)('R' + 'B' - currentColor);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
