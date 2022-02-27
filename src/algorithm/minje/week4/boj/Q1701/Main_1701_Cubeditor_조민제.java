package algorithm.minje.week4.boj.Q1701;
/*
메모리 : 110276KB
시간 : 296ms
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1701_Cubeditor_조민제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        int[] pi = new int[str.length];
        pi[0] = 0;
        int max = 0;

        for (int k = 0; k < str.length; k++) {
            pi = new int[str.length];
            pi[0] = 0;
            for (int i = 1, j = 0; i < str.length-k; i++) {
                while (j > 0 && str[i+k] != str[j+k]) j = pi[j - 1];
                if (str[i+k] == str[j+k]) {
                    pi[i] = ++j;
                }
            }
            for (int i : pi) {
                max = Math.max(i, max);
            }
        }

        System.out.println(max);
    }
}
