package algorithm.minje.week5.boj.Q1766;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1766_문제집_조민제 {
    static boolean[] problemSolved;
    static List[] preProblem;
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        problemSolved = new boolean[N]; //선행문제 저장 배열
        preProblem = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            preProblem[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int solvePrev = Integer.parseInt(st1.nextToken());
            int solveNext = Integer.parseInt(st1.nextToken());
            preProblem[solveNext].add(solvePrev);
        }

        solve(0);
        sb.append(1);
    }

    static void solve(int count){
        for (int i = 1; i <= N; i++) {
            if(problemSolved[i]){
                if(!preProblem[i].isEmpty()){
//                    solve()
                }
            }
        }
    }
}
