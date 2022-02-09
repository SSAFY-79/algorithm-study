/*
메모리 : 115160KB
시간 : 396ms
 */

package algorithm.minje.week2.boj.q1913;

import java.io.*;

public class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] numIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int[][] snale = new int[N][N];
        int r = 0, c = 0, d = 0, count = N * N;

        while (count != 0) {
            if (count == num) {
                numIdx = new int[]{r+1,c+1};
            }
            snale[r][c] = count--;
            if (r + dr[d] < 0 || r + dr[d] >= N || c + dc[d] < 0 || c + dc[d] >= N || snale[r + dr[d]][c + dc[d]] != 0) {
                d = (d + 1) % 4;
            }
            r += dr[d];
            c += dc[d];
        }

        for (int[] a : snale) {
            for (int b : a) {
                sb.append(b + " ");
            }
            sb.append("\n");
        }
        sb.append(numIdx[0] + " " + numIdx[1]);

        bw.write(sb.toString());
        bw.flush();
    }
}
