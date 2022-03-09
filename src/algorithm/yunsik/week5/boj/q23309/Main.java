package algorithm.yunsik.week5.boj.q23309;
import java.io.*;
import java.util.*;

public class Main {
    static int[] prev = new int[1000001];
    static int[] next = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(10000000);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        prev[first] = first;
        next[first] = first;
        for (int i = 1; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            makeNode(first, input);
            first = next[first];
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "BN":
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    sb.append(next[a]).append("\n");
                    makeNode(a, b);
                    break;
                case "BP":
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    sb.append(prev[a]).append("\n");
                    makeNode(prev[a], b);
                    break;
                case "CN":
                    a = Integer.parseInt(st.nextToken());
                    sb.append(next[a]).append("\n");
                    removeNode(next[a]);
                    break;
                case "CP":
                    a = Integer.parseInt(st.nextToken());
                    sb.append(prev[a]).append("\n");
                    removeNode(prev[a]);
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void removeNode(int item) {
        next[prev[item]] = next[item];
        prev[next[item]] = prev[item];
    }

    private static void makeNode(int cur, int input) {
        prev[input] = cur;
        next[input] = next[cur];
        prev[next[input]] = input;
        next[cur] = input;
    }
}