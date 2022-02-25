package algorithm.jungin.etc.q12910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] candy = new int[51];
        for (int i = 0; i < n; i++) {
            candy[Integer.parseInt(st.nextToken())] += 1;
        }
        int sum = 0;
        int pow = 1;
        for (int i = 1; i <= n; i++) {
            if (candy[i] == 0)
                break;
            pow *= candy[i];
            sum += pow;
        }
        System.out.println(sum);
    }
}