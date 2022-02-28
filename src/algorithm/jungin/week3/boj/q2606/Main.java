package algorithm.jungin.week3.boj.q2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, P, computer[][], flag[], cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        computer = new int[N + 1][N + 1];
        flag = new int[N + 1];
        int a, b;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            computer[a][b] = 1;
            computer[b][a] = 1;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        flag[1] = 1;
        while (!stack.empty()) {
            int peek = stack.pop();
            for (int i = 1; i <= N; i++) {
                if (computer[peek][i] == 1) {
                    if (flag[i] == 0) {
                        stack.add(i);
                        flag[i] = 1;
                        cnt += 1;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}