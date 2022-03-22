package algorithm.yunsik.week5.boj.q3055;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static int[][] distFromWater;
    static int[] start, destinataion;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        List<int[]> waterLocation = new ArrayList<>();
        distFromWater = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(distFromWater[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                switch (board[i][j]) {
                    case '*':
                        waterLocation.add(new int[]{i, j, 0});
                        break;
                    case 'S':
                        start = new int[]{i, j, 0};
                        break;
                    case 'D':
                        destinataion = new int[]{i, j};
                        break;
                }
            }
        }

        calcDistFromWater(waterLocation);
        int ans = bfs();
        if (ans == Integer.MAX_VALUE) bw.write("KAKTUS");
        else bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visit = new boolean[R][C];
        visit[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cost = poll[2];
            if (poll[0] == destinataion[0] && poll[1] == destinataion[1]) {
                return cost;
            }
            for (int i = 0; i < 4; i++) {
                int nextR = poll[0] + dr[i];
                int nextC = poll[1] + dc[i];
                if (isInvalidRange(nextR, nextC) || board[nextR][nextC] == 'X') continue;
                if (visit[nextR][nextC]) continue;
                if (isAlmostWater(nextR, nextC, cost + 1)) continue;
                visit[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC, cost + 1});
            }
        }
        return Integer.MAX_VALUE;
    }

    private static void calcDistFromWater(List<int[]> waterLocation) {
        boolean[][] visit = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] pos : waterLocation) {
            visit[pos[0]][pos[1]] = true;
            queue.offer(pos);
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int dist = poll[2];
            distFromWater[poll[0]][poll[1]] = dist;
            for (int i = 0; i < 4; i++) {
                int nextR = poll[0] + dr[i];
                int nextC = poll[1] + dc[i];
                if (isInvalidRange(nextR, nextC)) continue;
                if (board[nextR][nextC] == 'X' || board[nextR][nextC] == 'D') continue;
                if (visit[nextR][nextC]) continue;
                visit[nextR][nextC] = true;
                queue.offer(new int[]{nextR, nextC, dist + 1});
            }
        }
    }

    private static boolean isInvalidRange(int r, int c) {
        return r < 0 || c < 0 || r >= R || c >= C;
    }

    private static boolean isAlmostWater(int r, int c, int cost) {
        return distFromWater[r][c] <= cost;
    }
}
