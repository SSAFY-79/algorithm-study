package algorithm.kwangwoo.week4.boj.q16202;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] adjMatrix;
    static boolean[] visited;
    // static int[] distance;
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

        adjMatrix = new int[N][N];
        visited = new boolean[N];
        // distance = new int[N];
        parents = new int[N];

        Node[] nodes = new Node[N];

        for(int i=0; i<M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            // adjMatrix[from][to] = adjMatrix[to][from] = (i+1);
            nodes[i] = new Node(from, to, i+1);
        }

        // 정렬
        Arrays.sort(nodes);
        
        // kruskacal
        makeSet();
        int result = 0;
        int cnt = 0;
        for(Node node:nodes){
            if(union(node.from, node.to)){
                result += node.weight;
                if(++cnt == N-1){
                    break;
                }
            }
        }

        // 하나 지우기


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
