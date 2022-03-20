package algorithm.kwangwoo.week7.boj.q1647;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int m;
    static int n;

    static int totalCost = 0;
    static LinkedList<Edge> edges;
    static int[] parents;

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
    
    static void makeSet() {
        parents = new int[m];

        for (int i = 0; i < m; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (a == parents[a]) {
            return a;
        } else {
            return parents[a] = findSet(parents[a]);
        }
    }

    static boolean union(int a, int b) {
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

        m = sc.nextInt();
        n = sc.nextInt();

        edges = new LinkedList<Edge>();

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a == 0 && b == 0) {
                break;
            }
            int c = sc.nextInt();
            totalCost += c;

            edges.add(new Edge(a, b, c));
        }
        
        Collections.sort(edges);

        makeSet();
        
        int minCost = 0;
        int cnt = 0;
        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                minCost += e.cost;
                cnt++;
                if (cnt == m - 1) {
                    break;
                }
            }
        }

        System.out.println(totalCost - minCost);
        sc.close();
    }
}