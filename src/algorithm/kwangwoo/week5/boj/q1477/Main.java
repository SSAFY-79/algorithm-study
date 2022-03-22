package algorithm.kwangwoo.week5.boj.q1477;

import java.util.*;

public class Main {

    static int N;
    static int M;
    static int L;
    static int[] arr;

    public static void main(String[] args) {
        // 입력 ----------------------------------------
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        // 입력 끝 --------------------------------------

        // 값 넣기 --------------------------------------
        arr = new int[N + 2];

        // 시작점
        arr[0] = 0;
        // 중간 휴게소 값들
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        // 끝점
        arr[N + 1] = L;
        // 값 넣기 끝 ------------------------------------

        // 정렬
        Arrays.sort(arr);

        // 이분탐색 --------------------------------------
        int left = 1;
        int right = L;
        while (left <= right) {
            // 휴게소의 간격
            int mid = (left + right) / 2;

            // 간격을 정해놓고 휴게소 사이에 몇개가 들어갈 수 있는지 확인
            // 1. 휴게소 개수가 일치할때까지 반복
            // 2. 휴게소 개수가 일치했다면, 간격을 조정
            if (checkRange(mid)) {
                //
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        // 이분탐색 끝 -----------------------------------

        // 출력
        System.out.println(left);

        sc.close();
    }

    public static boolean checkRange(int mid) {

        // 들어갈 수 있는 휴게소의 전체 개수
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            // 휴게소와 휴게소 사이에서, 특정 값(mid)으로 간격을 두었을 때 둘 수 있는 휴게소의 개수
            count += (arr[i + 1] - arr[i] - 1) / mid;
        }

        if (count > M) {
            // 휴게소가 M개 이상이라면 특정 값(mid)을 늘림(휴게소가 적게 들어가도록)
            return true;
        } else {
            // 휴게소가 M개 이하라면 특정 값(mid)을 줄임(휴게소가 많이 들어가도록)
            return false;
        }
    }
}
