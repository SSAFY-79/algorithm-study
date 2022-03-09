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

    // 심사대 기준으로, T초만큼 시간이 지나면, 각 심사대는 n명씩 통과할 수 있음
    // 따라서 T초마다 모든 심사대에서 통과시킬 수 있는 사람수를 파악하여 계산
    public static void binarySearch(){
        // 초의 범위를 지정
        // 최소 : 1초
        long start = 1;
        // 최대 : 가장 느린 심사대 * 사람 수
        long end = maxTime * M;
        
        while(start <= end){
            // 정답(특정 초)을 찾기위해 이분탐색을 할 중앙값
            long mid = (start + end) / 2;
            // 특정 시간일 때, 사람이 지나갈 수 있는 수의 합
            long sum = 0;
            for(int i = 0; i < N; i++){
                // 특정 시간(mid)일 때, 해당 심사대에서 사람이 지나갈 수 있는 수
                sum += mid / times[i];
            }
            // 통과한 사람 수가 M 이상이면 
            if(sum >= M){
                // 더 적은 시간으로 목표를 달성할 수 있으므로 끝값을 줄임
                // start ~ (mid-1)까지 재탐색
                end = mid - 1;
            }
            // sum이 M 미만이면
            else{
                // 더 많은 시간이 필요하므로, 시작값을 키움
                // (mid+1) ~ end 까지 재탐색
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
}