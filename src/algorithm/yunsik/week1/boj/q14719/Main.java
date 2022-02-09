package algorithm.yunsik.week1.boj.q14719;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        st.nextToken();
        int m = Integer.parseInt(st.nextToken());
        int[] height = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int ans = 0;
        int bound = height[0];
        for (int i = 1; i < m; i++) {
            if (height[i - 1] < height[i]) {
                int cur = i - 1;
                while (cur >= 0 && height[cur] < Math.min(bound, height[i])) {
                    cur--;
                }

                if (cur != -1) {
                    int temp = 0;
                    for (int j = i - 1; j > cur; j--) {
                        ans += Math.min(bound, height[i]) - Math.max(temp, height[j]);
                        temp = Math.max(temp, height[j]);
                    }
                }
                bound = Math.max(bound, height[i]);
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
