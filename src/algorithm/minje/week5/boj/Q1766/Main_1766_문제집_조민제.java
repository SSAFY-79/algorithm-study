package algorithm.minje.week5.boj.Q1766;

/*
메모리 : 53276KB
시간 : 476ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1766_문제집_조민제 {
    static boolean[] problemSolved;
    static PriorityQueue<Integer> problemWillSolved = new PriorityQueue<>();
    static Queue<Integer>[] adjList;
    static int[] remainProblem;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        problemSolved = new boolean[N + 1];
        remainProblem = new int[N + 1];
        adjList = new Queue[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int solvePrev = Integer.parseInt(st1.nextToken());
            int solveNext = Integer.parseInt(st1.nextToken());
            adjList[solvePrev].add(solveNext);
            remainProblem[solveNext]++;
        }

        for (int i = 1; i <= N; i++) {
            if (remainProblem[i] == 0) {
                problemWillSolved.offer(i);
                problemSolved[i] = true;
            }
        }

        while (!problemWillSolved.isEmpty()) {
            int cur = problemWillSolved.poll();
            sb.append(cur + " ");
            int size = adjList[cur].size();
            for (int i = 0; i < size; i++) {
                int cand = adjList[cur].poll();
                remainProblem[cand] -= 1;
                if (remainProblem[cand] == 0) {
                    problemSolved[cand] = true;
                    problemWillSolved.offer(cand);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
