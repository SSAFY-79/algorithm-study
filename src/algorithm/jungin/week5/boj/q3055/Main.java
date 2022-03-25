package algorithm.jungin.week5.boj.q3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char map[][];
    static Node dLoc, sLoc;
    static boolean visited[][];
    static List<char[][]> mapList;

    static class Node {
        int x;
        int y;
        int num;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'D') {
                    dLoc = new Node(i, j, 0);
                } else if (map[i][j] == 'S') {
                    sLoc = new Node(i, j, 0);
                }
            }
        }
        mapList = new ArrayList<>();
        mapList.add(map);
        // 깊은 복사
        char newMap[][] = new char[R][];
        for (int i = 0; i < R; i++) {
            newMap[i] = map[i].clone();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(sLoc);
        while (!queue.isEmpty()) {
            sLoc = queue.poll();
            if (sLoc.x == dLoc.x && sLoc.y == dLoc.y) {
                System.out.println(sLoc.num);
                return;
            }


            // 다음 맵으로 계속 업데이트
            if (mapList.size() <= sLoc.num + 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '*') {
                            for (int k = 0; k < 4; k++) {
                                if (isRange(i + dx[k], j + dy[k]) && map[i + dx[k]][j + dy[k]] != 'D' && map[i + dx[k]][j + dy[k]] != 'X') {
                                    newMap[i + dx[k]][j + dy[k]] = '*';
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < R; i++) {
                    map[i] = newMap[i].clone();
                }
                mapList.add(map);
            } else {
                for (int i = 0; i < R; i++) {
                    map[i] = mapList.get(sLoc.num)[i].clone();
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = sLoc.x + dx[i];
                int nextY = sLoc.y + dy[i];
                if (isRange(nextX, nextY) && map[nextX][nextY] != '*' && map[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
                    queue.add(new Node(nextX, nextY, sLoc.num + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }
        System.out.println("KAKTUS");
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}