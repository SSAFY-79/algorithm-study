package algorithm.kwangwoo.week5.boj.q1766;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int M;
    static int readyCnt[];
    static ArrayList<Integer> nextProblems[];
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        pq = new PriorityQueue<>();
        sb = new StringBuilder();

        // N개만큼의 int배열 생성
        readyCnt = new int[N + 1];

        // N개만큼의 List생성
        nextProblems = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            nextProblems[i] = new ArrayList<>();
        }

        // 우선순위가 있는 것들을 입력받고,
        for (int i = 0; i < M; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            // 특정문제를 풀기 전, 풀어야하는 문제의 개수를 카운트(값이 0이면, 해당 문제를 풀 수 있음)
            readyCnt[second]++;
            // 해당 문제를 푼 다음에 풀 수 있는 문제 add
            nextProblems[first].add(second);
        }

        // 바로 풀 수 있는 문제은 차례대로 pq에 삽입
        for (int i = 1; i < N + 1; i++) {
            if (readyCnt[i] == 0) {
                pq.offer(i);
            }
        }

        // pq를 꺼내면서 반복
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            // 해당 문제를 푼 후에 풀 수 있는 문제들을 차례로 꺼냄
            for (int i = 0; i < nextProblems[cur].size(); i++) {
                int next = nextProblems[cur].get(i);
                // 해당 문제를 풀기 위해, 미리 풀어야하는 문제의 개수 -1
                readyCnt[next]--;
                // 해당 문제를 풀 수 있게 되었다면
                if (readyCnt[next] == 0) {
                    // pq에 추가하여, 더 쉬운 난이도라면 먼저 풀도록 함
                    pq.offer(next);
                }
            }
        }

        System.out.println(sb);
        sc.close();
    }
}