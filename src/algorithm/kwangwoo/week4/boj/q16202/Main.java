package algorithm.kwangwoo.week4.boj.q16202;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[] parents;

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;
        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        parents = new int[N];

        LinkedList<Node> nodes = new LinkedList<Node>();

        for(int i=0; i<M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            // adjMatrix[from][to] = adjMatrix[to][from] = (i+1);
            nodes.add(new Node(from, to, i+1));
        }

        // 정렬
        // Collections.sort(nodes, (o1, o2) -> o1.weight - o2.weight);

        for(int i=0; i<K; i++){
            // 서로소 만들기
            makeSet();

            int result = 0;
            int cnt = 0;
            // 모든 노드를 확인하면서
            for(Node node:nodes){
                // 합칠 수 있는지 확인하고, 합침
                if(union(node.from, node.to)){
                    // 합칠 수 있었으면, 결과에 더하기
                    result += node.weight;
                    if(++cnt == N-1){
                        break;
                    }
                }
            }
            // 하나 지우기
            nodes.remove(0);
        
            // MST가 완성되었다면 비용 출력
            if(cnt == N-1){
                System.out.print(result + " ");
            }
            // 아니면 0 출력
            else{
                System.out.print(0 + " ");
            }
        }
        
        sc.close();
    }

    static void makeSet(){
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }
    }

    static int findSet(int n){
        if(parents[n] == n){
            return n;
        }else{
            return parents[n] = findSet(parents[n]);
        }
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot){
            return false;
        }else{
            parents[bRoot] = parents[aRoot];
            return true;
        }
    }
}
