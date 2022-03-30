package algorithm.yunsik.week8.boj.q2812;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        st.nextToken();
        int k = Integer.parseInt(st.nextToken());
        Stack<Character> stack = new Stack<>();
        for (char c : br.readLine().toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k-- > 0) {
            stack.pop();
        }

        for (char c : stack) {
            sb.append(c);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
