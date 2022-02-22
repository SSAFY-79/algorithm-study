package algorithm.minje.week3.boj.q9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N, locationList[];
    static int ans=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        locationList = new int[N];

        dfs(0);

        sb.append(ans);
        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(int count) {
        if(count == N-1){
            ans++;
            return;
        }

        Loop: for (int newLoc = 0; newLoc < N; newLoc++) {
            for (int i = 0; i < count; i++) {
                if (locationList[i] == newLoc || Math.abs(i - count) == Math.abs(locationList[i] - newLoc)) {
                    continue Loop;
                }
            }
            locationList[count] = newLoc;
            dfs(count + 1);
            //놔도 되는곳이면
        }
    }
}
