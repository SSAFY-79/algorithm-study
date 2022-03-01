package algorithm.yunsik.week4.q16202;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            edges.add(new Edge(a, b, i + 1));
        }

        for (int i = 0; i < k; i++) {
            parent = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            int cnt = 0, j = 0, sum = 0;
            for (; cnt < n - 1 && j < edges.size(); j++) {
                Edge edge = edges.get(j);
                if (getParent(edge.a) == getParent(edge.b)) continue;
                if (minVal > edge.cost) {
                    minVal = edge.cost;
                    minIdx = j;
                }
                union(edge.a, edge.b);
                cnt++;
                sum += edge.cost;
            }

            if (cnt != n - 1) {
                for (int l = i; l < k; l++) {
                    bw.append("0 ");
                }
                break;
            } else {
                edges.remove(minIdx);
                bw.append(String.valueOf(sum)).append(" ");
            }
        }
        bw.flush();
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        parent[b] = a;
    }

    private static int getParent(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = getParent(parent[a]);
    }

    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int cost;

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
