package algorithm.kwangwoo.week8.boj.q13398;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[][] dp = new int[2][n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
		dp[0][0] = arr[0];
        dp[1][0] = arr[0];

        // dp[0][i] : 처음부터 i까지 모든 수를 더했을 때의 최대값 (max(이전까지의 최대값+자기자신 vs 자기자신))
        // dp[1][i] : 자기자신을 제거(앞에서 제거한 적X)하거나 안하거나(앞에서 제거한적 O)

        for (int i = 1; i < n; i++) {
            // 이전까지 합 + 자신 vs 자신
            dp[0][i] = Math.max(dp[0][i - 1] + arr[i], arr[i]);
            // 이전까지의 합(자신 제외) vs 이전에 한번 제외했던 합 + 자신
            dp[1][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[i]);
            
            // 제일 큰 값
			max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
		}

        System.out.println(max);
        
        sc.close();
    }
}