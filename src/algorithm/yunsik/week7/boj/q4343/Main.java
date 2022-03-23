package algorithm.yunsik.week7.boj.q4343;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent = new int[500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            for (int i = 0; i < P; i++) {
                parent[i] = i;
            }
            int[][] pos = new int[P][2];
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    edges.add(new int[]{j, i, getDist(pos[i], pos[j])});
                }
            }
            int ans = 0;
            Collections.sort(edges, Comparator.comparingInt(i -> i[2]));
            for (int i = 0, cnt = 0; cnt < P - S; i++) {
                int[] edge = edges.get(i);
                if (union(edge[0], edge[1])) {
                    cnt++;
                    ans = Math.max(ans, edge[2]);
                }
            }
            bw.write(String.format("%.2f\n", Math.sqrt(ans)));
        }
        bw.flush();
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        else parent[b] = a;
        return true;
    }

    private static int getParent(int a) {
        if (a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);
    }

    private static int getDist(int[] pos1, int[] pos2) {
        return (pos1[0] - pos2[0]) * (pos1[0] - pos2[0]) +
                (pos1[1] - pos2[1]) * (pos1[1] - pos2[1]);
    }
}
