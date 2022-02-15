package algorithm.kwangwoo.week3.boj.q20365;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력 -------------------------------
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String S = sc.next();

        // ------------------------------------

        // 처음에 쭉 칠할 값
        char std = S.charAt(0);

        // 연속적으로 이어지는지 확인하는 플래그
        boolean seqFlag = false;

        // 칠하는 횟수(처음엔 한번 다 칠한다 생각하고 1)
        int cnt = 1;

        for(int i=0; i<N; i++){
            // 처음 칠한 색이랑 다르면
            if(std != S.charAt(i)){
                // 연속으로 칠하는 중이면 넘어가고
                if(seqFlag){
                    continue;
                }
                // 새롭게 칠하는 중이면 cnt+1, flag ON
                else{
                    seqFlag = true;
                    cnt++;
                }
            }
            // 처음색과 같아지면(연속적으로 칠하는 과정 끝)
            else{
                seqFlag = false;
            }
        }
        System.out.println(cnt);

        sc.close();
    }
}
