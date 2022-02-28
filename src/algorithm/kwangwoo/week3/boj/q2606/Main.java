package algorithm.kwangwoo.week3.boj.q2606;

import java.util.Scanner;

class Main{
    static int nodeCnt;
    static int edgeCnt;

    static int ans = 0;
    // 방문 여부 확인
    static boolean[] visited;

    // 인접행렬 그래프 생성
    static boolean[][] table;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        nodeCnt = sc.nextInt();
        edgeCnt = sc.nextInt();

        // 1부터 값이 들어오므로 +1사이즈 만큼의 인접행렬 생성
        table = new boolean[nodeCnt+1][nodeCnt+1];
        
        // 각 정점의 방문여부 확인하는 배열 생성
        visited = new boolean[nodeCnt+1];

        // 인접행렬 생성
        for(int i=0; i<edgeCnt; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            table[s][e] = true;
            table[e][s] = true;
        }
        
        // 재귀 수행
        search(1);

        // 자기 자신 제외
        System.out.println(ans-1);
        sc.close();
    }

    public static void search(int n){
        // 2. 조건에 만족하므로 감염(ans++), 방문(visited true)
        // 처음 들어온 경우엔 한번 바로 수행(조건에 만족했기 때문에 생략)
        ans++;
        visited[n] = true;

        // 1. 조건에 만족해야지만 재귀
        // from -> to만 생각하기
        for(int i=1; i<= nodeCnt; i++){
            // 인접하고 && 방문하지 않았다면
            if(table[n][i] && !visited[i]){
                // 재귀 수행
                search(i);
            }
        }
    }
}