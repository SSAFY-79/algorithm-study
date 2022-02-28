/*
메모리 11632kb
시간 88ms
 */

package algorithm.minje.week2.boj.q2578;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static String[][] nums = new String[5][5];
    static int[] row = new int[5];
    static int[] col = new int[5];
    static int diag = 0;
    static int rdiag = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < 5; i++) {  //for input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                nums[i][j] = st.nextToken();
            }
        }
        int mcCount = 0;
        Loop:
        for (int i = 0; i < 5; i++) {   //for find num
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                mcCount++;
                find(st.nextToken());
                if (isBingo()) {
                    sb.append(mcCount);
                    break Loop;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }

    static void find(String num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (num.equals(nums[i][j])) {
                    row[i] += 1;
                    col[j] += 1;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 4) {
                        rdiag++;
                    }
                    return;
                }
            }
        }
    }

    static boolean isBingo() {
        int bingo = 0;
        if (diag == 5) bingo++;
        if (rdiag == 5) bingo++;
        for (int i = 0; i < 5; i++) {
            if (row[i] == 5) bingo++;
            if (col[i] == 5) bingo++;
        }

        if (bingo >= 3)
            return true;
        return false;
    }
}
