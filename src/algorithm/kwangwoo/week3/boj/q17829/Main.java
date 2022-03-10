package algorithm.kwangwoo.week3.boj.q17829;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 입력 -------------------------------
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] table = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                table[i][j] = sc.nextInt();
            }
        }
        // -----------------------------------

        Convolution(table, N);

        sc.close();
    }

    static void Convolution(int[][] input, int n){

        // n이 1이되면 출력
        if(n == 1){
            System.out.println(input[0][0]);
        }else{
            // 가로세로절반 사이즈(총 1/4)의 table 생성
            int[][] temp = new int[n/2][n/2];

            // 각 사각형의 좌상단을 기준으로 전체 조회
            for(int y=0; y<n; y+=2){
                for(int x=0; x<n; x+=2){
                    // 해당 구역 4개중 두번째로 큰값을 저장하기
                    
                    // 값 가져와서
                    int[] values = new int[4];
                    values[0] = input[y][x];
                    values[1] = input[y][x+1];
                    values[2] = input[y+1][x];
                    values[3] = input[y+1][x+1];
    
                    // 정렬 후에
                    Arrays.sort(values);
    
                    // 두번째로 큰 값을 저장
                    temp[y/2][x/2] = values[2];
                }
            }
            // 절반사이즈의 테이블과, 그 사이즈로 다시 재귀
            Convolution(temp, n/2);
        }
    }
}