package algorithm.jungin.week2.boj.q4396;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][];
        int[][] new_map = new int[n][n];
        char[][] run_map = new char[n][];
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map[i] = s.toCharArray();
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            run_map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                if (map[i][j] == '*') {
                    new_map[i][j] = '*';
                    if (run_map[i][j] == 'x')
                        flag = true;
                    continue;
                }
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] < 0 || i + dx[k] >= n || j + dy[k] < 0 || j + dy[k] >= n)
                        continue;
                    if (map[i + dx[k]][j + dy[k]] == '*')
                        tmp += 1;
                }
                new_map[i][j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (run_map[i][j] == 'x') {
                    if (new_map[i][j] == '*')
                        System.out.print("*");
                    else
                        System.out.print(new_map[i][j]);
                } else if (flag) {
                    if (new_map[i][j] == '*')
                        System.out.print("*");
                    else
                        System.out.print(".");
                } else
                    System.out.print(".");

            }
            System.out.println();
        }
    }
}