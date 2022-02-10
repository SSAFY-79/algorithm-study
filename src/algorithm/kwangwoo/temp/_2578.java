package algorithm.kwangwoo.temp;

import java.util.Scanner;

public class _2578 {
    static boolean[][] bingo = new boolean[5][5];

    static boolean check_cross1 = false;  // /
    static boolean check_cross2 = false;  // \
    static boolean[] check_row = new boolean[5];
    static boolean[] check_col = new boolean[5];
    
    
    static int[][] arr = new int[5][5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        int result = 0;
        for(int i=0; i<25; i++){
            cnt++;

            // 해당좌표 체크하기
            int[] xy = checkBooltable(sc.nextInt());

            // 빙고 확인 여부
            if(!check_cross1){
                checkCross1();
            }if(!check_cross2){
                checkCross2();
            }

            checkRow(xy[0]);
            checkCol(xy[1]);

            // 빙고가 3개면 끝
            if(result == 0 && sum() >= 3){
                result = cnt;
            }
            
        }
        System.out.println(result);
        sc.close();
    }

    public static int sum(){
        int cnt = 0;
        for(boolean b : check_row){
            if(b){
                cnt++;
            }
        }
        for(boolean b : check_col){
            if(b){
                cnt++;
            }
        }
        if(check_cross1){
            cnt++;
        }
        if(check_cross2){
            cnt++;
        }
        return cnt;
    }

    public static int[] checkBooltable(int temp){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(arr[i][j] == temp){
                    bingo[i][j] = true;
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void checkRow(int col){
        for(int i=0; i<5; i++){
            if(!bingo[col][i]){
                return;
            }
        }
        check_row[col] = true;
    }

    public static void checkCol(int row){
        for(int i=0; i<5; i++){
            if(!bingo[i][row]){
                return;
            }
        }
        check_col[row] = true;
    }

    public static void checkCross1(){
        int row = 0;
        int col = 4;

        for(int i=0; i<5; i++){
            if(!bingo[col][row]){
                return;
            }
            col--;
            row++;
        }
        check_cross1 = true;
    }

    public static void checkCross2(){
        int row = 0;
        int col = 0;

        for(int i=0; i<5; i++){
            if(!bingo[col][row]){
                return;
            }
            col++;
            row++;
        }
        check_cross2 = true;
    }
}