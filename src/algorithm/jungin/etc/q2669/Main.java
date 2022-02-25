package algorithm.jungin.etc.q2669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start_x, start_y, end_x, end_y;
        int[][] map = new int[100][100];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            start_x = Integer.parseInt(st.nextToken());
            start_y = Integer.parseInt(st.nextToken());
            end_x = Integer.parseInt(st.nextToken());
            end_y = Integer.parseInt(st.nextToken());

            for (int x = start_x; x < end_x; x++) {
                for (int y = start_y; y < end_y; y++) {
                    map[x][y] = 1;
                }
            }

        }
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1)
                    sum += 1;
            }
        }
        System.out.println(sum);
    }
}
