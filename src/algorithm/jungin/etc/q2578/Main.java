package algorithm.jungin.etc.q2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] flag = new int[5][5];
    static int count = 0;
    static int[] bingo = new int[12];   // 0-4: 가로, 5-9: 세로, 10: 오른 대각선, 11: 왼 대각선

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int[] pos = map.get(Integer.parseInt(st.nextToken()));
                int x = pos[0];
                int y = pos[1];
                flag[x][y] = 1;
                if (find(x, y)) {
                    System.out.println(i * 5 + (j + 1));
                    return;
                }
            }
        }
    }

    public static boolean find(int x, int y) {
        // 오른쪽 대각선
        if (x + y == 4 && bingo[10] == 0) {
            for (int i = 0; i < 5; i++) {
                if (flag[i][4 - i] == 0)
                    break;
                // 5개가 연속으로 있을 때
                if (i == 4) {
                    bingo[10] = 1;
                    count += 1;
                }
            }
        }
        // 왼쪽 대각선
        if (x == y && bingo[11] == 0) {
            for (int i = 0; i < 5; i++) {
                if (flag[i][i] == 0)
                    break;
                if (i == 4) {
                    bingo[11] = 1;
                    count += 1;
                }
            }
        }
        // 가로
        if (bingo[x] == 0) {
            for (int i = 0; i < 5; i++) {
                if (flag[x][i] == 0)
                    break;
                if (i == 4) {
                    bingo[x] = 1;
                    count += 1;
                }
            }
        }
        // 세로
        if (bingo[x + 5] == 0) {
            for (int i = 0; i < 5; i++) {
                if (flag[i][y] == 0)
                    break;
                if (i == 4) {
                    bingo[y + 5] = 1;
                    count += 1;
                }
            }
        }
        if (count >= 3)
            return true;
        return false;
    }
}