package algorithm.yunsik.week8.boj.q10775;

import java.io.*;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= G; i++) {
            set.add(i);
        }
        int cnt;
        for (cnt = 0; cnt < P; cnt++) {
            int input = Integer.parseInt(br.readLine());
            Integer floor = set.floor(input);
            if(floor == null) break;
            set.remove(floor);
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
