package algorithm.kwangwoo.week3.boj.q20115;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력 ------------------------------
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[] arr = new double[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        // ------------------------------------

        // 정렬
        Arrays.sort(arr);

        // 더하기
        for(int i=0; i<N-1; i++){
            arr[N-1] += arr[i]/2;
        }

        // 출력
        System.out.println(arr[N-1]);

        sc.close();
    }
}
