package algorithm.minje.week6.boj.Q1005;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int T, N, K, W, inDegree[], dp[], times[];
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            dp = new int[N + 1];
            inDegree = new int[N + 1];
            adjList = new LinkedList[N + 1];
            times = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                adjList[i] = new LinkedList<>();
            }

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int time = Integer.parseInt(st1.nextToken());
                times[i] = time;
            }
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st2.nextToken());
                int to = Integer.parseInt(st2.nextToken());
                adjList[from].add(to);
                inDegree[to]++;
            }

            W = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < N + 1; i++) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                    dp[i] = times[i];
                }
            }


            LOOP:
            while (!q.isEmpty()) {
                int cur = q.poll();
                if (cur == W) {
                    break LOOP;
                }

                for (int i = 0, size = adjList[cur].size(); i < size; i++) {
                    int cand = adjList[cur].poll();
                    inDegree[cand]--;
                    dp[cand]=Math.max(dp[cand],dp[cur]+times[cand]);
                    if (inDegree[cand] == 0) {
                        q.offer(cand);
                    }
                }
            }

            bw.write(dp[W]+"\n");
        }
        bw.flush();
    }
}
