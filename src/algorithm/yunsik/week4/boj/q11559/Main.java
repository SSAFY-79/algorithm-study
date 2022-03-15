package algorithm.yunsik.week4.boj.q11559;

import java.io.*;
import java.util.*;

public class Main {
    public static final int ROW_NUM = 12;
    public static final int COL_NUM = 6;
    public static final int BOOM_THRESHOLD = 4;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> popSet = new LinkedList<>();
    static char[][] board;
    static boolean[][] visit = new boolean[ROW_NUM][COL_NUM];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        board = new char[ROW_NUM][];
        for (int i = 0; i < ROW_NUM; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        while (tryPopAndReturnWhether()) {
            moveDown();
            ans++;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static void moveDown() {
        Queue<Character> temp = new LinkedList<>();
        for (int col = 0; col < COL_NUM; col++) {
            for (int row = 0; row < ROW_NUM; row++) {
                if(board[row][col] == '.') continue;
                temp.offer(board[row][col]);
                board[row][col] = '.';
            }
            while (!temp.isEmpty()) {
                int idx = ROW_NUM - temp.size();
                board[idx][col] = temp.poll();
            }
        }
    }

    private static boolean tryPopAndReturnWhether() {
        visit = new boolean[ROW_NUM][COL_NUM];
        for (int i = 0; i < ROW_NUM; i++) {
            for (int j = 0; j < COL_NUM; j++) {
                if (board[i][j] == '.' || visit[i][j]) continue;
                popSet.addAll(getPopSubSet(i, j));
            }
        }

        if(popSet.isEmpty()) return false;
        while(!popSet.isEmpty()){
            int[] position = popSet.poll();
            board[position[0]][position[1]] = '.';
        }
        return true;
    }

    private static Queue<int[]> getPopSubSet(int x, int y) {
        char color = board[x][y];
        queue.offer(new int[]{x, y});
        Queue<int[]> removeCandidate = new LinkedList<>();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (visit[poll[0]][poll[1]]) continue;
            visit[poll[0]][poll[1]] = true;
            removeCandidate.offer(poll);
            for (int k = 0; k < 4; k++) {
                int px = poll[0] + dx[k];
                int py = poll[1] + dy[k];
                if (isInvalidRange(px, py) || color != board[px][py]) continue;
                int[] next = {px, py};
                queue.offer(next);
            }
        }

        if(removeCandidate.size() >= BOOM_THRESHOLD){
            return removeCandidate;
        }
        removeCandidate.clear();
        return removeCandidate;
    }

    private static boolean isInvalidRange(int x, int y) {
        return x < 0 || y < 0 || x >= ROW_NUM || y >= COL_NUM;
    }
}
