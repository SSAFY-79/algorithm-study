package algorithm.minje.week2.boj.q4396;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static char[][] bombMap;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        bombMap = new char[n][n];
        char[][] ansBomb = new char[n][n];
        char[][] ans = new char[n][n];
        boolean bombClicked = false;
        
        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            bombMap[i] = Arrays.copyOf(tmp,tmp.length);
            ansBomb[i] = Arrays.copyOf(tmp,tmp.length);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 'x') {
                    char bombNum = calcBomb(i, j);
                    if(bombMap[i][j]=='*')
                        bombClicked = true;
                    else{
                        ansBomb[i][j] = bombNum;
                        ans[i][j] = bombNum;
                    }
                }
            }
        }

        if(bombClicked){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(ansBomb[i][j]);
                }
                sb.append("\n");
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(ans[i][j]);
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static char calcBomb(int r, int c) {
        int count = 0 + '0';
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (r + dr >= 0 && r + dr < n && c + dc >= 0 && c + dc < n) {
                    if (bombMap[r + dr][c + dc] == '*')
                        count++;
                }
            }
        }
        return (char) count;
    }
}
