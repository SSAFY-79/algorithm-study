package algorithm.jungin.week3.boj.q20365;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] color = br.readLine().toCharArray();

        char flag = color[0];
        int blue_cnt = 0, red_cnt = 0;
        for (int i = 1; i < color.length; i++) {
            if (flag == color[i])
                continue;
            if (flag == 'B') {
                blue_cnt += 1;
                flag = color[i];
            } else if (flag == 'R') {
                red_cnt += 1;
                flag = color[i];
            }
        }
        if (color[color.length - 1] == 'B')
            blue_cnt += 1;
        else
            red_cnt += 1;
        System.out.println(Math.min(blue_cnt + 1, red_cnt + 1));
    }
}