package algorithm.minje.week4.boj.Q1958;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1958_LCS_3_조민제 {

    static int longest=0;
    static char[] LCS;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] stringList = new char[3][];
        List<Character> fstSndLCS = new ArrayList<>(); //중간삽입 없으니 ArrayList

        for (int i = 0; i < 3; i++) {
            stringList[i] = br.readLine().toCharArray();
        }

        int comCnt = 0;
        int f = 0;
        int s = 0;
        for (int i = 0; i < stringList[0].length; i++) {
            f = i;
            while (stringList[0][f] == stringList[1][s]) {
                fstSndLCS.add(stringList[0][f]);
                comCnt++;
                f++;
                s++;
            }
            s=0;
            if(longest < comCnt){
                longest = comCnt;
                LCS = new char[longest];
                for (int chI = 0; chI<longest; chI++) {
                    LCS[chI] = fstSndLCS.get(chI);
                }
            }
        }


    }
}
