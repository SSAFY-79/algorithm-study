package algorithm.yunsik.week3.q9663;

import java.io.*;

public class Main {
    static int N;
    static int[] position;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        position = new int[N];
        int ans = dfs(0, 0);
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int dfs(int depth, int flag) {
        if (depth == N) return 1;
        int ret = 0;
        lb:
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) > 0) continue;
            for (int j = 0; j < depth; j++) {
                if ((position[depth - j - 1] == (i + j + 1))) continue lb;
                if ((position[depth - j - 1] == (i - j - 1))) continue lb;
            }
            position[depth] = i;
            ret += dfs(depth + 1, flag | (1 << i));
        }
        return ret;
    }
}
