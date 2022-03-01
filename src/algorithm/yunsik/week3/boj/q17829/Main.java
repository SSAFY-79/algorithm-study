package algorithm.yunsik.week3.boj.q17829;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        compress(n);
        bw.write(String.valueOf(board[0][0]));
        bw.flush();
    }

    private static void compress(int size) {
        if (size == 1) return;
        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < size; j += 2) {
                settle(i, j);
            }
        }
        compress(size / 2);
    }

    private static void settle(int i, int j) {
        int[] temp = {board[i][j], board[i][j + 1], board[i + 1][j], board[i + 1][j + 1]};
        Arrays.sort(temp);
        board[i / 2][j / 2] = temp[2];
    }
}
