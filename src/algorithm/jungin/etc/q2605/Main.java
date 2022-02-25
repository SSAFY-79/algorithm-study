package algorithm.jungin.etc.q2605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(st.nextToken());
            result.add(i - number, i + 1);
        }
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
