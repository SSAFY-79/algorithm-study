package algorithm.kwangwoo.week4.boj.q1261;

import java.util.*;
 
public class Main {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
 
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt; // 벽을 부순 개수
     
        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
     
        @Override
        public int compareTo(Node o) {
            return cnt - o.cnt;
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
 
        map = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        
        for (int i = 1; i <= N; i++) {
            String input = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = input.charAt(j-1) - '0';
            }
        }
 
        int ans = bfs(1, 1);
 
        System.out.println(ans);

        sc.close();
    }
 
    public static int bfs(int x, int y) {
        // 벽을 부순 개수가 적은 것부터 BFS를 진행하기 위한 PQ
        PriorityQueue<Node> pq = new PriorityQueue<>();
 
        // 방문체크 및 큐에 삽입
        visit[x][y] = true;
        pq.offer(new Node(x, y, 0));
 
        // 반복
        while (!pq.isEmpty()) {
            Node current = pq.poll();
 
            // 도착점에 도달했으면 종료.
            if (current.x == N && current.y == M) {
                return current.cnt;
            }
 
            for (int i = 0; i < 4; i++) {
                int di = current.x + dx[i];
                int dj = current.y + dy[i];
 
                // 인덱스 초과가 안나면서, 방문하지 않았다면,
                if (isAvailable(di, dj)){
                    // 방문체크
                    visit[di][dj] = true;
                    
                    // 빈 공간이라면
                    if (map[di][dj] == 0) {
                        pq.offer(new Node(di, dj, current.cnt));
                    }
                     // 벽이 있는 공간이라면
                    if (map[di][dj] == 1) {
                        pq.offer(new Node(di, dj, current.cnt + 1));
                    }
                }
            }
        }
        // 도착점에 도달하지 못하고 
        return 0;
    }
    
    static boolean isAvailable(int i, int j){
        if(i >= 1 && i <=N && j >= 1 && j <= M){
            if(!visit[i][j]){
                return true;
            }
        }
        return false;
    }
}