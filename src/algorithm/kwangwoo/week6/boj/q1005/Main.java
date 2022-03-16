package algorithm.kwangwoo.week6.boj.q1005;

import java.util.*;

class Main {
    // 건물(노드) 갯수
    static int N;
    // 간선 갯수 
    static int K;
    static int[] buildTimes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int curTC = 0; curTC < T; curTC++) {
            N = sc.nextInt();
            K = sc.nextInt();
            buildTimes = new int[N + 1];

            List<List<Integer>> list = new ArrayList<List<Integer>>();
            for (int i = 0; i < N + 1; i++) {
                list.add(new ArrayList<Integer>());
            }

            // 특정 건물을 짓기위해 미리 지어야하는 건물의 수
            int[] indegree = new int[N + 1];

            // 건물 별 건설 소요시간
            for (int i = 1; i <= N; i++) {
                buildTimes[i] = sc.nextInt();
            }

            // 선행 조건
            for (int i = 0; i < K; i++) {
                // v1 -> v2
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                // v1값 리스트에 v2를 추가
                // 해당 건물을 지으면 지을 수 있는 건물들이 나열됨
                list.get(v1).add(v2);
                // v2를 짓기 위해 지어야 하는 건물의 개수 +1
                indegree[v2]++;
            }

            // 목표 건물 W
            int W = sc.nextInt();

            func(indegree, list, W);
        }
        sc.close();
    }

    static void func(int[] indegree, List<List<Integer>> list, int W) {
        // 위상정렬을 위한 큐
        Queue<Integer> q = new LinkedList<Integer>();
        
        // 각 건물의 건설 시간을 저장할 배열
        int[] result = new int[N+1];

        // 건물의 소요 기본 소요시간은 buildTimes[i]
        for(int i=1; i<=N; i++) {
            result[i] = buildTimes[i];

            if (indegree[i] == 0) {
                // 바로 건설할 수 있는 건물들을 큐에 삽입
                q.offer(i);
            }
        }

        // Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
        while (!q.isEmpty()) {
            int builded = q.poll();

            // 현재 건물을 지으면 지을 수 있는 건물들을 차례로 조회
            for (int willBuild : list.get(builded)) {
                // 지을 수 있는 건물의 소요시간을 업데이트
                // 지금까지 오는데 걸린 시간 vs 현재건물까지 걸린 시간 + 현재 건물을 짓는데 걸리는 시간
                // Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있는데, 더 오랜 시간이 걸리는 것으로 해야함
                // 예를 들어 4까지 오기 위해 한 방법은 20초 , 다른 방법은 30초라면, 두 건물이 모두 지어져야하므로 30초가 되어야함
                result[willBuild] = Math.max(result[willBuild], result[builded] + buildTimes[willBuild]);
                // result[willBuild] = result[builded] + buildTimes[willBuild]; <- 안됨!
                
                // 조회된 건물을 짓기 위해 필요한 건물 수 -1 
                indegree[willBuild]--;

                // 해당 값이 0 이면 조회된 건물을 지을 수 있음
                if (indegree[willBuild] == 0) {
                    q.offer(willBuild);
                }
            }
        }

        // 원하는 건물의 최종 소요시간 출력
        System.out.println(result[W]);
    }
}