package algorithm.yunsik.week2.boj.q4396;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static char[][] board, ans;
    static final int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static final int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};
    static int n;
    static List<int[]> ePos = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        board = new char[n][];
        ans = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], '.');
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    ePos.add(new int[]{i, j});
                }
            }
        }

        String input;
        int cnt;
        boolean exp = false;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'x') {
                    if (board[i][j] == '*') {
                        exp = true;
                    } else {
                        cnt = 0;
                        for (int k = 0; k < 8; k++) {
                            if (inRange(i + dx[k], j + dy[k]) && board[i + dx[k]][j + dy[k]] == '*') {
                                cnt++;
                            }
                        }
                        ans[i][j] = (char) (cnt + '0');
                    }
                }
            }
        }

        if(exp){
            for (int[] pos : ePos) {
                ans[pos[0]][pos[1]] = '*';
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
