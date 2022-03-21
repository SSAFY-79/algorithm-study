package algorithm.kwangwoo.week7.boj.q4386;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n;

    static Star[] stars;
    static int[] parents;
    static LinkedList<Edge> distance;

    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        double dist;
        int fromIdx;
        int toIdx;

        public Edge(double dist, int fromIdx, int toIdx) {
            this.dist = dist;
            this.fromIdx = fromIdx;
            this.toIdx = toIdx;
        }
        
        @Override
        public int compareTo(Edge o) {
            return (int) (this.dist - o.dist);
        }
    }

    public static void makeSet() {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    public static int findSet(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = findSet(parents[a]);
        }
    }
    
    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        } else {
            parents[bRoot] = aRoot;
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        stars = new Star[n];
        distance = new LinkedList<Edge>();

        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            stars[i] = new Star(x, y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    distance.add(new Edge(Math.sqrt(Math.pow(Math.abs(stars[i].x - stars[j].x), 2)
                            + Math.pow(Math.abs(stars[i].y - stars[j].y), 2)), i, j));
                }
            }
        }
        
        Collections.sort(distance);

        makeSet();
        double result = 0;
        int cnt = 0;
        for (Edge d : distance) {

            if (union(d.fromIdx, d.toIdx)) {
                result += d.dist;
                cnt++;
                if (cnt == n - 1) {
                    break;
                }
            }
            
        }

        System.out.println(Math.round(result*100.0)/100.0);

        sc.close();
    }
}
