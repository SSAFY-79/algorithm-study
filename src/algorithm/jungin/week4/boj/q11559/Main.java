package algorithm.jungin.week4.boj.q11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static char map[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] visited;
    static List<Character> new_map[];
    static boolean flag;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        new_map = new ArrayList[6];

        for (int i = 0; i < 6; i++) {
            new_map[i] = new ArrayList<>();
        }
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                new_map[j].add(map[i][j]);
            }
        }

        int cnt = 0;
        flag = true;
        while (flag) {
            flag = false;
            visited = new int[12][6];

            // map 업데이트
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    map[i][j] = new_map[j].get(i);
                }
            }
            // 모든 좌표 탐색, 그 동안 map은 바뀌지 않는다.
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] == '.')
                        continue;
                    if (visited[i][j] == 0)
                        bfs(i, j, map[i][j]);
                }
            }
            if (flag)
                cnt += 1;

        }
        System.out.println(cnt);
    }

    public static void bfs(int x, int y, char c) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        queue.add(new Node(x, y));
        visited[x][y] = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            list.add(poll);
            int n_x = poll.x, n_y = poll.y;
            for (int k = 0; k < 4; k++) {
                if (n_x + dx[k] < 0 || n_x + dx[k] >= 12 || n_y + dy[k] < 0 || n_y + dy[k] >= 6)
                    continue;
                // 같은 문자면 queue에 추가
                if (visited[n_x + dx[k]][n_y + dy[k]] == 0 && map[n_x + dx[k]][n_y + dy[k]] == c) {
                    queue.add(new Node(n_x + dx[k], n_y + dy[k]));
                    visited[n_x + dx[k]][n_y + dy[k]] = 1;
                }
            }
        }
        // 4개 이상이면 list에서 없애고 '.'을 추가
        if (list.size() >= 4) {
            flag = true;
            for (int i = 0; i < list.size(); i++) {
                new_map[list.get(i).y].remove(list.get(i).x);
                new_map[list.get(i).y].add(0, '.');
            }
        }
    }
}