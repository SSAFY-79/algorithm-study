package algorithm.kwangwoo.week5.boj.q3055;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int R;
    static int C;
    static char[][] map;

    // 방문여부와 물의 위치를 저장할 배열
    static boolean[][] visited;

    // 시작점과 도착점
    static int[] start;
    static int[] dest;

    // 물을 bfs하기 위한 queue
    // Node 중 time은 딱히 사용 X
    static Queue<Node> waterIndexs = new LinkedList<Node>();

    // 상하좌우
    static final int[] dx = { 0, 0, -1, 1 };
    static final int[] dy = { -1, 1, 0, 0 };

    static class Node implements Comparable<Node> {
        int y;
        int x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'D') {
                    dest = new int[] { i, j };
                } else if (map[i][j] == 'S') {
                    start = new int[] { i, j };
                } else if (map[i][j] == '*') {
                    waterIndexs.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        bfs(new Node(start[0], start[1], 0));

        sc.close();
    }

    static void watering() {
        int qSize = waterIndexs.size();

        for (int i = 0; i < qSize; i++) {
            Node cur = waterIndexs.poll();

            for (int j = 0; j < 4; j++) {
                int ii = cur.y + dy[j];
                int jj = cur.x + dx[j];

                if (isAvailable(ii, jj)) {
                    if (map[ii][jj] != 'D') {
                        visited[ii][jj] = true;
                        waterIndexs.offer(new Node(ii, jj, 0));
                    }

                }
            }
        }
    }

    static void bfs(Node n) {
        LinkedList<Node> pq = new LinkedList<Node>();
        visited[n.y][n.x] = true;

        pq.offer(n);

        while (!pq.isEmpty()) {
            watering();

            int qSize = pq.size();
            for (int loop = 0; loop < qSize; loop++) {
                Node cur = pq.poll();

                // 탈출 조건
                if (cur.y == dest[0] && cur.x == dest[1]) {
                    System.out.println(cur.time);
                    return;
                }

                // 가능하면 pq에 추가
                for (int i = 0; i < 4; i++) {
                    int di = cur.y + dy[i];
                    int dj = cur.x + dx[i];

                    if (isAvailable(di, dj)) {
                        visited[di][dj] = true;
                        pq.offer(new Node(di, dj, cur.time + 1));
                    }
                }
            }
        }
        // pq가 전부 비었는데 탈출 못했으면 불가능
        System.out.println("KAKTUS");
    }

    static boolean isAvailable(int i, int j) {
        // 인덱스 초과 X
        if (i >= 0 && i < R && j >= 0 && j < C) {
            // 돌이 아니라면
            if (map[i][j] != 'X') {
                // 방문하지 않았다면
                if (!visited[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
