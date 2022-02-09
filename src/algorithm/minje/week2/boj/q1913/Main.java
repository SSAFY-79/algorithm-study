package algorithm.minje.week2.boj.q1913;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, num;
    static int[][] snale;
    static int[] numIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        snale = new int[N][N];

        recursive((int) Math.pow(N, 2), 0, 0, 0);

        for (int[] a : snale) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println(numIdx[0]+" "+numIdx[1]);
    }

    static void recursive(int count, int d, int r, int c) {
        if(count == num) numIdx = new int[]{r+1,c+1};
        if (count == 0) return;
        snale[r][c] = count--;
        if (r + dr[d] >= 0 && r + dr[d] < N && c + dc[d] >= 0 && c + dc[d] < N && snale[r + dr[d]][c + dc[d]] == 0) {
            recursive(count, d, r + dr[d], c + dc[d]);

        } else {
            d = (d + 1) % 4;
            recursive(count, d, r + dr[d], c + dc[d]);
        }
    }
}
