package algorithm.kwangwoo.week8.boj.q2811;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int N;
    static int K;
    static int[] arrInputInt;
	static int count = 0;
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        String input = sc.next();
        arrInputInt = new int[N];
        
        // 입력숫자의 각 자리를 배열에 넣음
        for (int i = 0; i < input.length(); i++) {
            arrInputInt[i] = input.charAt(i) - '0';
        }

        // 다음 자리수가 더 크다면 빼는게 더 이득임!
        for (int i = 0; i < arrInputInt.length; i++) {
            // 뺄 숫자가 남아있고(count<K), stack이 비어있지 않으며, "stack의 top이 현재 자리수보다 작다면"
            while (count < K && !stack.isEmpty() && stack.peek() < arrInputInt[i]) {
                // 스택에 있던 기존 값을 빼버림
                stack.pop();
                count++;
            }
            // 해당 자릿수를 스택에 push
            stack.push(arrInputInt[i]);
        }
        
        // 출력
        for (int i = 0; i < N - K; i++) {
            // 스택 요소를 bottom부터 출력
            System.out.print(stack.elementAt(i));
        }

        sc.close();
	}
}