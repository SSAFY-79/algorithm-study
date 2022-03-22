package algorithm.yunsik.week5.boj.q1766;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] must = new List[n + 1];
        int[] requiredCnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            must[i] = new ArrayList();
        }
        for (int i = 0, a, b; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            must[a].add(b);
            requiredCnt[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (requiredCnt[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            bw.append(String.valueOf(poll)).append(" ");
            for (Integer idx : must[poll]) {
                if (--requiredCnt[idx] == 0)
                    queue.offer(idx);
            }
        }
        bw.flush();
    }
}
