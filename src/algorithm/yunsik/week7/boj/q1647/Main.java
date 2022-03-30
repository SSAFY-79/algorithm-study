package algorithm.yunsik.week7.boj.q1647;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static List<int[]> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0, x, y, z; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            edges.add(new int[]{x, y, z});
        }

        int ans = 0;
        Collections.sort(edges, Comparator.comparing(i -> i[2]));
        for (int i = 0, cnt = 0; cnt < n - 2; i++) {
            int[] edge = edges.get(i);
            if (union(edge[0], edge[1])) {
                ans += edge[2];
                cnt++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    }

    private static int getParent(int a) {
        if (a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);
    }
}
