package algorithm.kwangwoo.week2.boj.q4396;
import java.util.*;

class Main{
    static boolean isfail = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 범위조절대신 상하좌우에 1칸씩 더 선언
        boolean[][] boomTable = new boolean[n+2][n+2];
        boolean[][] isOpen = new boolean[n+2][n+2];

        // 결과값을 출력할 배열
        char[][] result = new char[n][n];

        // 폭탄 위치
        for(int i=1; i<=n; i++){
            String s = sc.next();
            for(int j=1; j<=n; j++){
                if(s.charAt(j-1) == '*'){
                    boomTable[i][j] = true;
                }
            }
        }

        // 오픈 유무
        for(int i=1; i<=n; i++){
            String s = sc.next();
            for(int j=1; j<=n; j++){
                if(s.charAt(j-1) == 'x'){
                    isOpen[i][j] = true;
                    if(boomTable[i][j]){
                        isfail = true;
                    }
                }
            }
        }
        // 입력 끝 ----------------

        // Open된곳만 돌면서 팔방확인
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(isOpen[i][j]){
                    result[i-1][j-1] = (char)(search8side(boomTable, i, j)+'0');
                }else{
                    result[i-1][j-1] = '.';
                }
            }
        }

        if(isfail){
            // 폭탄의 위치를 전부 result에 넣어주기
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(boomTable[i][j]){
                        result[i-1][j-1] = '*';
                    }
                }
            }
        }

        // 출력
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
    public static int search8side(boolean[][] arr, int x, int y){
        int cnt = 0;

        // 자기자신 포함상태
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(arr[x+i][y+j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}