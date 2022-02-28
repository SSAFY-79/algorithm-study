package algorithm.jungin.week4.boj.q1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, map[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = c[j] - '0';
            }
        }
        bfs(0, 0);
    }

    public static void bfs(int x, int y) {
        Deque<Node> deque = new ArrayDeque<>();
        Node[][] check = new Node[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j] = new Node(-1, -1);
            }
        }
        deque.addFirst(new Node(x, y));

        // 0-1 bfs 알고리즘
        while (!(x == N - 1 && y == M - 1)) {
            Node node = deque.poll();
            x = node.x;
            y = node.y;

            for (int i = 0; i < 4; i++) {
                if (x + dx[i] < 0 || x + dx[i] >= N || y + dy[i] < 0 || y + dy[i] >= M)
                    continue;
                if (map[x + dx[i]][y + dy[i]] == 0 && check[x + dx[i]][y + dy[i]].x == -1) {
                    deque.addFirst(new Node(x + dx[i], y + dy[i]));
                    check[x + dx[i]][y + dy[i]] = new Node(x, y);
                } else if (map[x + dx[i]][y + dy[i]] == 1 && check[x + dx[i]][y + dy[i]].x == -1) {
                    deque.addLast(new Node(x + dx[i], y + dy[i]));
                    check[x + dx[i]][y + dy[i]] = new Node(x, y);
                }
            }
        }
        // 경로 추적
        x = N - 1;
        y = M - 1;
        int cnt = 0, tmpX, tmpY;
        while (!(x == 0 && y == 0)) {
            if (map[x][y] == 1)
                cnt += 1;
            tmpX = x;
            tmpY = y;
            x = check[tmpX][tmpY].x;
            y = check[tmpX][tmpY].y;
        }
        System.out.println(cnt);
    }
}