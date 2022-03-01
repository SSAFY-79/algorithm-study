package algorithm.jungin.week4.boj.q16202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, parent[];
    static Edge edges[];

    static class Edge {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        edges = new Edge[M + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
        }
        for (int j = 1; j <= K; j++) {
            for (int k = 1; k <= N; k++) {
                parent[k] = k;
            }
            System.out.print(mst(j) + " ");
        }
    }

    public static int mst(int start) {
        int weight = 0;
        for (int i = start; i <= M; i++) {
            if (find_parent(edges[i].x) != find_parent(edges[i].y)) {
                union_parent(edges[i].x, edges[i].y);
                weight += edges[i].weight;
            }

        }
        for (int j = 1; j <= N; j++) {
            // parent[j]로 하면 업데이트 안 된 값이 들어갈 수도 있어서 마지막에 다시 find_parent 해야 함.
            // 루트가 1이 아니면 연결되지 않은 것이 있음.
            if (find_parent(j) != 1)
                return 0;
        }
        return weight;
    }

    public static int find_parent(int x) {
        if (parent[x] != x)
            parent[x] = find_parent(parent[x]);
        return parent[x];
    }

    public static void union_parent(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }
}