package algorithm.minje.week4.boj.Q11559;
/*
메모리 : 11864KB
시간 : 88ms
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_11559_Puyo_Puyo_조민제 {
    static final int R = 12, C = 6, dr[] = {1, -1, 0, 0}, dc[] = {0, 0, -1, 1};
    static char[][] map = new char[R][C];
    static boolean[][] visited = new boolean[R][C];
    static int comb;    // 뿌요 연쇄값
    static List<int[]> trashBin = new ArrayList<>();    //뿌요면 삭제할 쓰레기통

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < 12; r++) {
            map[r] = br.readLine().toCharArray();
        }

        while (true) {
            boolean isPuyo = false;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] != '.' && checkPuyo(r, c)) {
                        isPuyo = true;
                        removeCells();
                    }
                }
            }
            if (isPuyo) {
                comb++;
                actGravity();
                visited = new boolean[R][C];
            }
            if (!isPuyo) break;
        }


        sb.append(comb);
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean checkPuyo(int r, int c) {
        trashBin.clear();
        Queue<int[]> q = new LinkedList<>();
        int count = 1;
        visited[r][c] = true;

        q.offer(new int[]{r, c});
        trashBin.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (isValidRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
                    count++;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    trashBin.add(new int[]{nr, nc});
                }
            }
        }
        return count >= 4;
    }

    static void removeCells() {
        for (int[] cells : trashBin) {
            map[cells[0]][cells[1]] = '.';
        }
    }

    static void actGravity() {
        Queue<Character> colors;
        for (int c = 0; c < C; c++) {
            colors = new LinkedList<>();

            for (int r = R - 1; r >= 0; r--) {
                if (map[r][c] != '.') colors.offer(map[r][c]);
            }
            for (int r = R - 1; r >= 0; r--) {
                if (colors.isEmpty()) {
                    map[r][c] = '.';
                    continue;  // for reduce depth
                }
                map[r][c] = colors.poll();
            }
        }
    }

    static boolean isValidRange(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
