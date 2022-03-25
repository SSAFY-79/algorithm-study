package algorithm.jungin.week7.boj.q2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, weight[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);
        int end;
        List<Integer> list = new ArrayList<>();
        if (weight[0] != 1) {
            System.out.println(1);
            return;
        }
        list.add(weight[0]);
        for (int i = 1; i < N; i++) {
            end = list.get(list.size() - 1);
            if (weight[i] <= end + 1 && list.size() != i - 1) {
                list.add(weight[i] + end);
                continue;
            }
        }
        System.out.println(list.get(list.size() - 1) + 1);
    }
}