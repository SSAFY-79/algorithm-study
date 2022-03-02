package algorithm.kwangwoo.week5.boj.q3079;

import java.util.*;

// 입국심사
class Main {
    static long N;
    static long M;
    static long maxTime;
    static int times[];
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //심사대 개수
        N = sc.nextLong(); 
        //친구 수
        M = sc.nextLong(); 

        // 각 심사대의 소요시간
        times = new int[(int)N];
 
        // 소요시간과, 가장 오래걸리는 소요시간 계산
        for(int i = 0; i < N; i++){
            times[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(times);
        
        // 가장 오래 걸리는 심사대의 시간
        maxTime = times[(int)(N-1)];

        // 이진탐색
        binarySearch();

        sc.close();
    }

    //1. start = 1, end = maxTime * M 로 설정함
    //2. 그래서 mid / times[i] 를 해서 sum에 다 더함
    //2-1. 더한 값이 사람 수보다 많거나 같을 때 mid를 줄여야함. 그래서 end = mid - 1을 해주고,
    //2-2. 더한 값이 사람 수보다 적으면 mid를 늘려야함. 그래서 start = mid + 1을 해주어야함.
    public static void binarySearch(){
        // 1초부터 시작
        long start = 1;
        // 가장 느린걸 심사대로 모두 갈 때가 마지막 
        long end = maxTime * M;
        
        while(start <= end){
            // 중간값 찾기
            long mid = (start + end) / 2;
            // 중간값으로 각 검사대를 거치는 시간
            long sum = 0;
            for(int i = 0; i < N; i++){
                sum += mid / times[i];
            }
            // sum이 M 이상이면
            if(sum >= M){
                // start ~ (mid-1)까지 재탐색
                end = mid - 1;
            }
            // sum이 M 미만이면
            else{
                // (mid+1) ~ end 까지 재탐색
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}