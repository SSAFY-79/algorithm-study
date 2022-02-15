package algorithm.jungin.etc.q16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n][m];
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            int max_x = n - i;
            int max_y = m - i;
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < max_x; j++) {
                list.add(map[j][i]);
            }
            for (int j = i + 1; j < max_y; j++) {
                list.add(map[max_x - 1][j]);
            }

            for (int j = max_x - 2; j >= i; j--) {
                list.add(map[j][max_y - 1]);
            }

            for (int j = max_y - 2; j > i; j--) {
                list.add(map[i][j]);
            }
            int start = list.size() - r % list.size();
            if (start == list.size())
                start = 0;
            for (int j = i; j < max_x; j++) {
                result[j][i] = list.get(start++);
                if (start == list.size())
                    start = 0;
            }
            for (int j = i + 1; j < max_y; j++) {
                result[max_x - 1][j] = list.get(start++);
                if (start == list.size())
                    start = 0;
            }

            for (int j = max_x - 2; j >= i; j--) {
                result[j][max_y - 1] = list.get(start++);
                if (start == list.size())
                    start = 0;
            }

            for (int j = max_y - 2; j > i; j--) {
                result[i][j] = list.get(start++);
                if (start == list.size())
                    start = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}