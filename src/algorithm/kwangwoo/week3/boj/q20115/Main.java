package algorithm.kwangwoo.week3.boj.q20115;

import java.util.Arrays;
import java.util.Scanner;

// 가장 많은 양이 있는 것을 버리면 안됨
// 따라서 작은것부터 가장 많은 것에 담는 식으로 구현

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[] arr = new double[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬하여 작은것부터 수행
        Arrays.sort(arr);

        // 적은 것부터 가장 많은 곳에 부움
        for(int i=0; i<N-1; i++){
            arr[N-1] += arr[i]/2;
        }
        
        System.out.println(arr[N-1]);

        sc.close();
    }
}