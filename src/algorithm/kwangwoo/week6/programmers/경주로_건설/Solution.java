package algorithm.kwangwoo.week6.programmers.경주로_건설;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    static class Road{
        int x,y,cost,dir;
        public Road(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

	static int min = Integer.MAX_VALUE;
	static int xx[] = {-1, 0, 1, 0};
	static int yy[] = {0, -1, 0, 1};
	static int map[][];
	static int n;
	static int answer;
	
    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        n = board.length;
        map = board;
        
        // 초기 방향을 -1 을 주는 이유는 자동차가 시작할때 오른쪽과 아래로 둘다 이동할수 있기 떄문이다.
        bfs(0, 0, 0, -1);
        return answer;
    }   
    
    public static void bfs(int x, int y, int cost, int dir) {
        Queue<Road> q = new LinkedList<Road>();
        q.add(new Road(x, y, cost, dir));
    	// 출발지점을 1 로 바꾸어 탐색에서 제외한다.
        map[x][y] = 1;
        
        while(!q.isEmpty()) {
            Road cur = q.poll();
            // 목적지에 도착했다면 최소비용을 갱신해준다.
            if(cur.x == n - 1 && cur.y == n - 1) {
                answer = Math.min(answer, cur.cost);
                continue;
            }

            // 4방향으로 이동할수있다 .
            for(int i = 0; i < 4; i++) {
                int new_x = cur.x + xx[i];
                int new_y = cur.y + yy[i];
                // 새로 이동하는 곳은 범위안이고 벽이(1) 아니여야한다.
                if(new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && map[new_x][new_y] != 1) {
                    int new_cost = 0;
                    // 새로운 지점의 비용구하기.
                    if(cur.dir == -1 || cur.dir == i) {
                        new_cost = cur.cost + 100;
                    }else if(cur.dir != i){
                        new_cost = cur.cost + 600;
                    }
                
                    //처음가는 곳이라면 정보를 넣어주면된다.
                    if(map[new_x][new_y] == 0) {
                        map[new_x][new_y] = new_cost;
                        q.add(new Road(new_x, new_y, new_cost, i));
                    }else if(map[new_x][new_y] >= new_cost) { //처음가지않는 곳이라면 비용이 더작거나 같은 경우 넣어주면된다.
                        map[new_x][new_y] = new_cost;
                        q.add(new Road(new_x, new_y, new_cost, i));
                    }
                    
                    
                }
            }
            
        }
    }
}
