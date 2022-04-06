package algorithm.kwangwoo.week8.boj.q14226;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 
visited[클리보드 개수][스크린 개수] 로 나눠서 진행

목표값을 초과한 후 지워서 값을 맞추는 경우는 없는 것인가?



*/

public class Main {
    static int S;

    static boolean[][] visited;

    static class emoticon {
        int clipboard = 0;
        int screen = 0;
        int sec = 0;
        
        emoticon(int clipboard, int screen, int sec){
            this.clipboard = clipboard;
            this.screen = screen;
            this.sec = sec;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        // [클립보드][스크린]
        // 범위가 S+1 이면 충분한게 맞나..?
        visited = new boolean[S + 1][S + 1];

        bfs(S);

        sc.close();
    }

    static void bfs(int target) {
        Queue<emoticon> q = new LinkedList<>();
        q.offer(new emoticon(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            emoticon cur = q.poll();

            // 목표에 도달하면 끝
            if (cur.screen == target) {
                System.out.println(cur.sec);
                return;
            }

            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            q.offer(new emoticon(cur.screen, cur.screen, cur.sec + 1));

            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            // cur.screen + cur.clipboard <= target 이어야하는 이유는?
            if (cur.clipboard != 0 && cur.screen + cur.clipboard <= target && !visited[cur.clipboard][cur.screen + cur.clipboard]) {
                q.offer(new emoticon(cur.clipboard, cur.screen + cur.clipboard, cur.sec + 1));
                visited[cur.clipboard][cur.screen + cur.clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
            if (1 <= cur.screen && !visited[cur.clipboard][cur.screen - 1]) {
                q.offer(new emoticon(cur.clipboard, cur.screen - 1, cur.sec + 1));
                visited[cur.clipboard][cur.screen - 1] = true;
            }
        }
    }
}
