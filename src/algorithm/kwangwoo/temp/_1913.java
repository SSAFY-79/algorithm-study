package algorithm.kwangwoo.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1913 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int target = Integer.parseInt(br.readLine());

        // 값을 저장할 배열
        int[][] result = new int[N][N];

        // target index를 저장할 배열
        int[] target_idx = new int[2];

        // 채우는 방향
        // 0 : 좌, 1 : 상, 2 : 우, 3 : 하
        int direct = 1;

        // 루프 반복 조절을 위한 방향 전환 카운트
        int direct_cnt = 0;

        // loop_cnt 조절
        int loop_cnt = 1;

        // idx 조절
        int col = N/2;
        int row = N/2;

        int seq = 1;

        while(seq <= N*N){
            // 한 방향으로 값 넣기
            for(int j=0; j<loop_cnt; j++){
                // 값 대입
                result[col][row] = seq;

                // 값 일치 시 index 저장
                if(seq == target){
                    target_idx = new int[] {col+1, row+1};  // index 0 시작에서, 1시작으로 변환
                }

                // 방향에 따른 index 조절
                switch(direct){
                    case 0: row--; break; // 위쪽 갈 때
                    case 1: col--; break; // 위로 갈 때
                    case 2: row++; break; // 오른쪽갈 때
                    case 3: col++; break; // 아래로 갈 때
                    default: break;
                }
                seq++;
            }

            // 방향 direct 조절
            direct = (direct+1)%4;
            direct_cnt++;

            // 반복횟수 조절
            if(direct_cnt == 2){
                loop_cnt++;
                direct_cnt = 0;   
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.write(target_idx[0] + " " + target_idx[1]);
        bw.flush();
        bw.close();
    }
}
