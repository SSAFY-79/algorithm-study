package algorithm.jungin.week3.boj.q9663;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, row[], col[], left_diag[], right_diag[], map[][], cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        left_diag = new int[2 * N - 1];
        right_diag = new int[2 * N - 1];

        nqueen(0);
        System.out.println(cnt);
    }

    public static void nqueen(int x) {
        for (int i = 0; i < N; i++) {
            if (col[i] == 0 && left_diag[x + i] == 0 && right_diag[N + x - i - 1] == 0) {
                if (x == N - 1) {
                    cnt += 1;
                    continue;
                }
                col[i] = 1;
                left_diag[x + i] = 1;
                right_diag[N + x - i - 1] = 1;
                nqueen(x + 1);
                col[i] = 0;
                left_diag[x + i] = 0;
                right_diag[N + x - i - 1] = 0;
            }
        }
        return;
    }
}