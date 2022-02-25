package algorithm.jungin.etc.q2564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int store_n = Integer.parseInt(br.readLine());

        // 가게 위치 저장 store_pos
        List<Integer> store_dValue = new ArrayList<>();
        List<int[]> store_pos = new ArrayList<>();
        int d, distance;
        for (int i = 0; i < store_n; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            store_dValue.add(d);
            store_pos.add(getPos(d, distance));
        }
        // 동근이 위치 저장 x, y
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        int[] pos = getPos(d, distance);

        int sum = 0;
        for (int i = 0; i < store_n; i++) {
            sum += getMin(d, pos, store_dValue.get(i), store_pos.get(i));
        }
        System.out.println(sum);
    }

    public static int getMin(int d, int[] pos, int store_d, int[] store_pos) {
        if ((d == 1 && store_d == 2) || (d == 2 && store_d == 1))
            return Math.min(pos[0] + store_pos[0] + m, (n - pos[0]) + (n - store_pos[0]) + m);
        else if ((d == 3 && store_d == 4) || (d == 4 && store_d == 3))
            return Math.min(pos[1] + store_pos[1] + n, (m - pos[1]) + (m - store_pos[1]) + n);
        return Math.abs(pos[0] - store_pos[0]) + Math.abs(pos[1] - store_pos[1]);
    }

    public static int[] getPos(int d, int distance) {
        int x, y;
        if (d == 1) {
            x = distance;
            y = 0;
        } else if (d == 2) {
            x = distance;
            y = m;
        } else if (d == 3) {
            x = 0;
            y = distance;
        } else {
            x = n;
            y = distance;
        }
        return new int[]{x, y};
    }
}