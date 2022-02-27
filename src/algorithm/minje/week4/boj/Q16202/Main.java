package algorithm.minje.week4.boj.Q16202;
/*

 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int dest;
    int weight;

    public Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int DEFAULT_STARTING = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge>[] adjList = new PriorityQueue[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new PriorityQueue<>();
        }

        int weight = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());
            weight++;

            Edge newE = new Edge(to, weight);
            adjList[from].add(newE);
            adjList[to].add(new Edge(from, weight));
        }


        for (int turn = 0; turn < K; turn++) {
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[N + 1];
            int cost = 0;
            for (Edge edge : adjList[DEFAULT_STARTING]) {
                pq.offer(edge);
            }
            visited[DEFAULT_STARTING] = true;

            while (!pq.isEmpty()) {
                Edge cur = pq.poll();
                if (!visited[cur.dest]) {
                    cost += cur.weight;
                    visited[cur.dest] = true;
                    for (Edge edge : adjList[cur.dest]) {
                        pq.offer(edge);
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) cost = 0;
            }
            sb.append(cost + " ");

            // ----------------poll minimum edge
            int min = Integer.MAX_VALUE;
            List<Integer> minList = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (!adjList[i].isEmpty()) {
                    int cand = adjList[i].peek().weight;
                    if (min > cand) {
                        min = cand;
                        minList.clear();
                    }
                    if (min == cand) {
                        minList.add(i);
                    }
                }
            }
            for (Integer integer : minList) {

                adjList[integer].poll();
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
