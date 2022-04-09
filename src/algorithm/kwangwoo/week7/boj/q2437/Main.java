package algorithm.kwangwoo.week7.boj.q2437;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int weights[] = new int[N];

        for (int i = 0; i < N; i++)
            weights[i] = sc.nextInt();

        Arrays.sort(weights);

        if (weights[0] == 1) {
            int canMake = 0;
        
            canMake = weights[0];

            for (int i = 1; i < N; i++) {
                // 만들수 있는 값 + 1 < 다음 weight라면 탈출
                // 다음으로 만드는 값을 못만든다는 뜻
                if (canMake + 1 < weights[i]) {
                    break;
                }
                // 다음 weight를 추가
                canMake += weights[i];
            }

            System.out.println(canMake + 1);

        } else {
            // 가장 작은 weigh가 1이 아니면 답은 1
            System.out.println(1);
        }

        sc.close();
    }
}
