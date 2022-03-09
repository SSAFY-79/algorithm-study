package algorithm.yunsik.week6.boj.q1005;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] needTime, mem;
    static List<Integer>[] required;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            needTime = new int[n];
            mem = new int[n];
            required = new List[n];
            for (int i = 0; i < n; i++) {
                required[i] = new ArrayList<>();
                mem[i] = -1;
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                needTime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0, a, b; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken()) - 1;
                b = Integer.parseInt(st.nextToken()) - 1;
                required[b].add(a);
            }
            int target = Integer.parseInt(br.readLine()) - 1;
            bw.append(String.valueOf(find(target))).append("\n");
            bw.flush();
        }
    }

    private static int find(int target) {
        if (mem[target] != -1) return mem[target];
        int ret = 0;
        for (Integer need : required[target]) {
            ret = Math.max(ret, find(need));
        }
        return mem[target] = (ret + needTime[target]);
    }
}
