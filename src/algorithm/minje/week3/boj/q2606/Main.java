package algorithm.minje.week3.boj.q2606;

/*
메모리 : 11828KB
시간 : 76ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int vertex;
    Node link;

    Node(int vertex,Node link){
        this.vertex = vertex;
        this.link = link;
    }
}

public class Main {
    static int N,infectedN;
    static Node[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        adjList = new Node[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to,adjList[from]);
            adjList[to] = new Node(from,adjList[to]);
        }

        bfs(1);

        sb.append(infectedN-1);
        bw.write(sb.toString());
        bw.flush();
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            for (Node from = adjList[cur]; from != null; from=from.link) {
                if(!visited[from.vertex]){
                    visited[from.vertex] = true;
                    infectedN++;
                    q.offer(from.vertex);
                }
            }
        }
    }
}
