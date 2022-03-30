package algorithm.yunsik.week7.boj.q4386;

import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double[][] pos = new double[n][2];
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pos[i][0] = Double.parseDouble(st.nextToken());
            pos[i][1] = Double.parseDouble(st.nextToken());
            for (int j = 0; j < i; j++) {
                edges.add(new Edge(j, i, getDist(pos[i], pos[j])));
            }
        }

        double ans = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Collections.sort(edges, Comparator.comparingDouble(e -> e.dist));
        for (int i = 0, cnt = 0; cnt < n - 1; i++) {
            Edge edge = edges.get(i);
            if (union(edge.a, edge.b)) {
                cnt++;
                ans += edge.dist;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    private static int getParent(int a) {
        if(parent[a] == a) return a;
        return parent[a] = getParent(parent[a]);
    }

    private static double getDist(double[] po1, double[] po2) {
        return Math.sqrt(Math.pow(po1[0] - po2[0], 2) + Math.pow(po1[1] - po2[1], 2));
    }

    static class Edge {
        int a, b;
        double dist;

        public Edge(int a, int b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }
}
