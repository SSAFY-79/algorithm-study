package algorithm.minje.week3.boj.q20365;
/*
메모리 : 19580KB
시간 : 152ms
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int paintCnt = 1;
    static char[] colorArr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        colorArr = new char[N];
        colorArr = br.readLine().toCharArray();

        char fstColor = colorArr[0];
        for (int i = 0; i < N; i++) {
            if(colorArr[i] != fstColor){
                paintCnt++;

                while(i<N-1){
                    if(colorArr[i] == colorArr[i+1]){
                        i++;
                    }
                    else{
                        break;
                    }
                }
            }
        }

        sb.append(paintCnt);
        bw.write(sb.toString());
        bw.flush();
    }

}
