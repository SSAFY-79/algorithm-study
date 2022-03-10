package algorithm.minje.week2.boj.q14467;

/*
메모리 : 11672KB
시간 : 76ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[10];
        Arrays.fill(cows,-1);  // default 초기화 <> 실 input 0과 구분짓기 위해

        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int cowNum = Integer.parseInt(st.nextToken()) - 1;
            int location = Integer.parseInt(st.nextToken());

            if(cows[cowNum] != -1 && cows[cowNum] != location){
                count++;
            }
            cows[cowNum] = location;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
    }
}
