package algorithm.yunsik.week3.boj.q2606;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int x, y, ans = 0;
        edges = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            edges[x].add(y);
            edges[y].add(x);
        }

        boolean[] already = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        already[1] = true;
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            for (Integer next : edges[poll]) {
                if(!already[next]){
                    ans++;
                    already[next] = true;
                    queue.offer(next);
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
