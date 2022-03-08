package algorithm.kwangwoo.week2.boj.q12933;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static char[] table = {'q', 'u', 'a', 'c', 'k'};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        boolean iswrong = false;
        int min_duck_cnt = -1;

        LinkedList<Character> list = new LinkedList<Character>();

        for(int i=0; i<input.length(); i++){
            // 값이 들어갔는지 확인
            boolean isPut = false;
            // 스택을 검사해봄
            for(int j=0; j<list.size(); j++){
                // 새로운 입력값이 다음 순서가 맞다면
                if(table[tableIndex(list.get(j))+1] == input.charAt(i)){
                    // 값 변경
                    list.set(j, input.charAt(i));
                    // 새로 삽입된게 k라면 해당 값 삭제
                    if(list.get(j) == 'k'){
                        list.remove(j);
                    }
                    isPut = true;
                    break;
                }
            }
            
            // 위 for문을 돌고도 남는 문자라면 (q 혹은 잘못된 순서)
            if(!isPut){
                // q라면 새로운 리스트 삽입
                if(input.charAt(i) == 'q'){
                    char temp = 'q';
                    list.add(temp);
                }else{
                    // 잘못된 순서
                    iswrong = true;
                    break;
                }
            }
            
            // 스택의 개수 = 오리의 최소 마리수
            min_duck_cnt = Math.max(min_duck_cnt, list.size());
        }

        // 출력
        // 잘못된 순서였거나, 아직 마무리가 안된 경우
        if(iswrong || list.size() > 0){
            System.out.println(-1);
        }else{
            System.out.println(min_duck_cnt);
        }
        sc.close();
    }

    public static int tableIndex(char c){
        for(int i=0; i<table.length; i++){
            if(table[i] == c){
                return i;
            }
        }
        System.out.println("error");
        return -1;
    } 
}
