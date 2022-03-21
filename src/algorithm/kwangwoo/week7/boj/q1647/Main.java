package algorithm.kwangwoo.week7.boj.q1647;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] parents;
    static Edge[] edges;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void makeSet() {
        parents = new int[N+1];

        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = findSet(parents[a]);
        }
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        } else {
            parents[bRoot] = aRoot;
            return true;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            edges[i] = new Edge(from, to, cost);
        }

        Arrays.sort(edges);

        int result = 0;
        int cnt = 0;
        makeSet();
        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                int curCost = e.cost;
                result += curCost;
                cnt++;
                if (cnt == N - 1) {
                    result -= curCost;
                    break;
                }
            }
        }
        System.out.println(result);
        sc.close();
    }
    
}
