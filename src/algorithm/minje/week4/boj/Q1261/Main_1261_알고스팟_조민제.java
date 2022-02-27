package algorithm.minje.week4.boj.Q1261;
/*
메모리 : 12460KB
시간 : 112ms
 */

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Path implements Comparable<Path> {
    int r;
    int c;
    int crashedWallCnt;

    public Path(int r, int c, int crashedWallCnt) {
        this.r = r;
        this.c = c;
        this.crashedWallCnt = crashedWallCnt;
    }

    @Override
    public int compareTo(Path o) {
        return this.crashedWallCnt - o.crashedWallCnt;
    }
}

public class Main_1261_알고스팟_조민제 {
    //상하좌우
    static int N, M, dr[] = {1, -1, 0, 0}, dc[] = {0, 0, -1, 1};
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        sb.append(bfs(new boolean[N][M]));
        bw.write(sb.toString());
        bw.flush();
    }

    static int bfs(boolean[][] visited) {
        PriorityQueue<Path> q = new PriorityQueue<>();
        visited[0][0] = true;
        q.offer(new Path(0, 0, 0));

        while (!q.isEmpty()) {
            Path cur = q.poll();
            if (cur.r == N - 1 && cur.c == M - 1) return cur.crashedWallCnt;
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int wallCnt = cur.crashedWallCnt;
                if (isValidRange(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == '1') wallCnt++;
                    q.offer(new Path(nr, nc, wallCnt));
                }
            }
        }
        return -1;
    }

    static boolean isValidRange(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < M;
    }
}
