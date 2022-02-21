package algorithm.minje.week3.boj.q17829;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, matrix[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        polling(2);

        sb.append(matrix[0][0]);

        bw.write(sb.toString());
        bw.flush();
    }

    static void rtSndBiggest(int r, int c,int size) {

        List<Integer> tmp = new ArrayList<>();

        for (int i = r; i < r+size; i+=size/2) {
            for (int j = c; j < c+size; j+=size/2) {
                tmp.add(matrix[i][j]);
            }
        }
        tmp.sort((a,b)->b-a);

        int sndBiggest = tmp.get(1);
        for (int i = r; i < r+size; i+=size/2) {
            for (int j = c; j < c+size; j+=size/2) {
                matrix[i][j]= sndBiggest;
            }
        }
    }

    static void polling(int size){

        for (int i = 0; i < N; i+=size) {
            for (int j = 0; j < N; j+=size) {
                rtSndBiggest(i,j,size);
            }
        }

        if(size == N) return;
        polling(size*2);
    }
}
