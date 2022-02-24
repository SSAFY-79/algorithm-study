package algorithm.kwangwoo.week3.boj.q20365;

import java.util.Scanner;

// 한색으로 전부 칠한 후, 다른 색으로 부분만 칠하는 식

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String S = sc.next();

        // 처음 색으로 일단 전부 칠함
        char std = S.charAt(0);
        int cnt = 1;
        
        // 연속적으로 칠하고 있는 중인지 확인하는 변수
        boolean isSeq = false;

        for(int i=0; i<N; i++){
            // 기준색과 다른 경우에
            if(std != S.charAt(i)){
                if(isSeq){
                     // 연속적으로 칠하고 있는 중이라면 continue;
                    continue;
                }else{
                    // 처음으로 칠하는 경우라면, paint색 바꾸고(cnt++) 연속적이라고 플래그 변경 
                    isSeq = true;
                    cnt++;
                }
            }else{
                // 다시 기준색이 되었으니, 연속X
                isSeq = false;
            }
        }
        System.out.println(cnt);

        sc.close();
    }
}