package algorithm.jungin.week7.boj.q1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M, parent[];

    static class Edge {
        int a;
        int b;
        int cost;

        Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Edge[] edges = new Edge[M];
        int a, b, cost;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, cost);
        }
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.sort(edges, Comparator.comparingInt(s -> s.cost));
        int totalCost = 0;
        for (int i = 0; i < M; i++) {
            int parentA = find_parent(edges[i].a);
            int parentB = find_parent(edges[i].b);
            if (parentA != parentB) {
                union_parent(parentA, parentB);
                totalCost += edges[i].cost;
            }
        }
        System.out.println(totalCost);
    }

    public static int find_parent(int x) {
        if (parent[x] != x) {
            parent[x] = find_parent(parent[x]);
        }
        return parent[x];
    }

    public static void union_parent(int x, int y) {
        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }
}