package algorithm.jungin.week7.boj.q4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, parent[];
    static double x[], y[], totalCost;

    static class Star {
        int a;
        int b;
        double cost;

        Star(int a, int b, double cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Star star[] = new Star[(N * (N - 1)) / 2];
        x = new double[N];
        y = new double[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }
        double dx, dy, distance;
        int index = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                dx = x[i] - x[j];
                dy = y[i] - y[j];
                distance = Math.round(Math.sqrt((dx * dx) + (dy * dy)) * 100) / 100.0;
                star[index++] = new Star(i, j, distance);
            }
        }
        Arrays.sort(star, Comparator.comparing(s -> s.cost));
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        totalCost = 0;
        for (int i = 0; i < star.length; i++) {
            int parentA = find_parent(star[i].a);
            int parentB = find_parent(star[i].b);
            if (parentA != parentB) {
                union_parent(parentA, parentB);
                totalCost += star[i].cost;
            }

        }
        System.out.println(totalCost);
    }

    public static int find_parent(int x) {
        if (parent[x] != x)
            parent[x] = find_parent(parent[x]);
        return parent[x];
    }

    public static void union_parent(int x, int y) {
        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }
}