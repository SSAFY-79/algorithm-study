package algorithm.kwangwoo.week3.boj.q9663;

import java.util.Scanner;

public class Main {
    static int N;
    static int col[];
    static int ansCnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        col = new int[N+1];
        ansCnt = 0;

        setQueen(1);
        System.out.println(ansCnt);

        sc.close();
    }

    // 입력으로 현재 퀸을 두어야하는 행의 위치
    public static void setQueen(int curRow){
        // 각 행에 퀸을 하나씩 둘 것임
        // 열로 이루어진 1차원 배열을 생각하고,
        // 배열[퀸의 행위치] = 퀸의 열 위치 로 구현
        // 세로에 있는 경우 : 이미 채워진 값(퀸의 열 위치)와 동일하면 유망(답 가능성)X
        // 대각선에 있는 경우 : 행과 열의 변화같이 서로 동일하면 유망(답 가능성)X
        
        // 3. 전부 조회했다면 리턴
        if(curRow > N){
            // 정답의 개수 카운트+1
            ansCnt++;
            return;
        }

        // 1. 모든 경우로 일단 둠
        for(int i=1; i<=N; i++){
            col[curRow] = i;

            // 2. 방금 둔 게, 유망(답의 가능성)하다면, 다음 재귀로 들어가기
            if(isAvailable(curRow)){
                setQueen(curRow+1);
            }
        }
    }

    // 현재 두어진 퀸과 이 전애 둔 다른 퀸들을 확인
    public static boolean isAvailable(int curRow){
        // 지금 까지 둔 퀸들을 비교
        for(int i=1; i<curRow; i++){
            // 같을 세로열에 있거나 || 가로행의 변화량이 세로행의 변화량과 같다면(curRow는 항상 i보다 큼)
            if(col[curRow] == col[i] || curRow-i == Math.abs(col[curRow] - col[i])){
                return false;
            }
        }
        return true;
    }
}
