package algorithm.yunsik.week2.boj.q2578;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] seq = new int[25];
    static int[] row = new int[]{5, 5, 5, 5, 5};
    static int[] col = new int[]{5, 5, 5, 5, 5};
    static int[] dia = new int[]{5, 5};
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                seq[i * 5 + j] = Integer.parseInt(st.nextToken());
            }
        }

        int cur = 0;
        int bingo = 0;
        while (cur < 25) {
            int[] location = map.get(seq[cur]);
            if (--row[location[0]] == 0 && ++bingo == 3) break;
            if (--col[location[1]] == 0 && ++bingo == 3) break;
            if (location[0] == location[1] && dia[0] == 0 && ++bingo == 3) break;
            if (location[0] + location[1] == 4 && --dia[1] == 0 && ++bingo == 3) break;
            cur++;
        }
        bw.write(String.valueOf(cur + 1));
        bw.flush();
    }
}
