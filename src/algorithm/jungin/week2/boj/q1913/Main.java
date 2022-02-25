package algorithm.jungin.week2.boj.q1913;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int count = 1;
        int x = n / 2, y = n / 2;
        map[x][y] = 1;
        int i = 2;
        while (true) {
            // 위
            for (int k = 0; k < count; k++) {
                map[--x][y] = i++;
            }
            // 왼
            for (int k = 0; k < count; k++) {
                map[x][++y] = i++;
            }
            count += 1;
            // 아래
            for (int k = 0; k < count; k++) {
                map[++x][y] = i++;
            }
            // 오
            for (int k = 0; k < count; k++) {
                map[x][--y] = i++;
            }
            count += 1;
            if(count == n)
                break;
        }
        // 마지막 줄 추가
        for (int r = n - 2; r >= 0; r--) {
            map[r][0] = i++;
        }
        int find_x = 0, find_y = 0;
        for (int l = 0; l < n; l++) {
            for (int m = 0; m < n; m++) {
                bw.write(map[l][m] + " ");
                if (map[l][m] == find) {
                    find_x = l;
                    find_y = m;
                }
            }
            bw.write("\n");
        }
        bw.write((find_x + 1) + " " + (find_y + 1));
        bw.flush();
        bw.close();
    }
}