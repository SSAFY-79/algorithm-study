package algorithm.yunsik.week7.boj.q6497;

import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        while (n != 0 || m != 0) {
            edges = new ArrayList<>();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            int ans = 0;
            for (int i = 0, x, y, z; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                edges.add(new int[]{x, y, z});
                ans += z;
            }

            Collections.sort(edges, Comparator.comparingInt(i -> i[2]));
            for (int i = 0, cnt = 0; i < edges.size() && cnt < n - 1; i++) {
                int[] edge = edges.get(i);
                if (union(edge[0], edge[1])) {
                    cnt++;
                    ans -= edge[2];
                }
            }
            bw.append(String.valueOf(ans)).append("\n");
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }
        bw.flush();
    }

    private static int getParent(int a) {
        if (a == parent[a]) return a;
        else return parent[a] = getParent(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    }
}
