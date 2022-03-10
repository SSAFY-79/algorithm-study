package algorithm.jungin.week3.boj.q17829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(cal(0, 0, N));
    }

    public static int cal(int row, int col, int size) {
        if (size == 2) {
            return getSecondMax(map[row][col], map[row + size / 2][col], map[row][col + size / 2], map[row + size / 2][col + size / 2]);
        }
        return getSecondMax(cal(row, col, size / 2), cal(row + size / 2, col, size / 2),
                cal(row, col + size / 2, size / 2), cal(row + size / 2, col + size / 2, size / 2));
    }

    public static int getSecondMax(int a, int b, int c, int d) {
        int arr[] = new int[]{a, b, c, d};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] >= second)
                second = arr[i];
        }
        return second;
    }
}