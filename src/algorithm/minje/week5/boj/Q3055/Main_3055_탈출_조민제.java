package algorithm.minje.week5.boj.Q3055;
/*
메모리 : 11984KB
시간 : 92ms
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_3055_탈출_조민제 {
    static char[][] map;
    static char WATER = '*';
    static char GO_SEUM_DO_CHI = 'S';
    static char BEBBER_CAVE = 'D';
    static char EMPTY_LAND = '.';

    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};
//    static int[] GS_LOC; //고슴도치 위치
//    static int[] BC_LOC; //비버의굴 위치
    static int time = 0;
    static Queue<int[]> waterQ = new LinkedList<>();
    static Queue<int[]> pathQ = new LinkedList<>();
    static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                inputHandler(input[j], new int[]{i, j});
                map[i][j] = input[j];
            }
        }

        do {
            time++;
            if (pathQ.size() == 0) {
                System.out.println("KAKTUS");
                break;
            }
            waterSpread();
        } while (!moveGS());

    }

    public static void waterSpread() {
        int size = waterQ.size();
        while (size-- > 0) {
            int[] cur = waterQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (isValidRange(nr, nc) && isEmptyLand(nr, nc)) {
                    map[nr][nc] = WATER;
                    waterQ.offer(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean moveGS() {
        int size = pathQ.size();
        while (size-- > 0) {
            int[] cur = pathQ.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (isValidRange(nr, nc)) {
                    if (arrived(nr, nc)) {
                        System.out.println(time);
                        return true;
                    }
                    if (isEmptyLand(nr, nc)) {
                        map[nr][nc] = WATER; //물로 방문체크
                        pathQ.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }

    public static boolean isValidRange(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }

    public static boolean isEmptyLand(int nr, int nc) {
        return map[nr][nc] == EMPTY_LAND;
    }

    public static boolean arrived(int nr, int nc) {
        return map[nr][nc] == BEBBER_CAVE;
    }

    public static void inputHandler(char input, int[] curCord) {
        if (input == GO_SEUM_DO_CHI) {
            pathQ.offer(curCord);
        }
//        if (input == BEBBER_CAVE) {
//            BC_LOC = curCord;
//        }
        if (input == WATER) {
            waterQ.offer(curCord);
        }
    }
}
