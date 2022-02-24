package algorithm.kwangwoo.week1.boj.q5557;

import java.util.*;

// 참조
// https://jellyinghead.tistory.com/55

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        // 0~20 까지의 값 위치를 저장할 배열
        long[] frame = new long[21];

        // 초기값
        frame[arr[0]] += 1;

        // 입력값 반복(마지막 제외)
        for(int i=1; i<N-1; i++){
            
            // 값을 저장할 리스트
            long[] temp = new long[21];

            // 프레임 중 값이 들어있는 부분 찾기
            for(int j=0; j<21; j++){
                // 값이 들어있다면,
                if(frame[j] > 0){
                    // 뺐을 때
                    if(j - arr[i] >= 0){
                        temp[j-arr[i]] += frame[j];
                    }
                    // 더했을 때
                    if(j + arr[i] <= 20){
                        temp[j+arr[i]] += frame[j];
                    }
                }
            }
            frame = temp;
        }
        System.out.println(frame[arr[N-1]]);
        sc.close();
    }
}
