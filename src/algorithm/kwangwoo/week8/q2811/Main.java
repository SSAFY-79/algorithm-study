package algorithm.kwangwoo.week8.q2811;

import java.util.Scanner;

public class Main {

    static int N;
    static int K;
    static String input;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        input = sc.next();
        
        String curStr = input;
        StringBuilder sb = new StringBuilder();

        // 제거할 숫자 개수만큼 반복
        for (int i = 1; i <= K; i++) {
            String preStr = curStr;
            for (int j = 0; j < preStr.length(); j++) {
                // 숫자 하나 뺀 str만들기 
                for (int k = 0; k < preStr.length(); k++) {
                    if (k != j) {
                        sb.append(preStr.charAt(k));
                    }
                }
                // String tempStr = sb.toString();

                // 만들어진 str과 기존 str과 비교하기
                for (int k = 0; k < sb.toString().length(); k++) {
                    if (curStr.charAt(k) < sb.toString().charAt(k)) {
                        curStr = sb.toString();
                        break;
                    } else if (curStr.charAt(k) == sb.toString().charAt(k)) {
                        continue;
                    } else {
                        break;
                    }
                }
                
                // sb초기화
                sb.setLength(0);
            }
        }

        System.out.println(curStr);
        sc.close();
    }
}