package algorithm.kwangwoo.week1.boj.q14719;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        List<Integer> myList = new ArrayList<>(width);

        for(int i=0; i<width; i++){
            myList.add(sc.nextInt());
        }
        
        // 높이 제거하기
        int heightest = Collections.max(myList);
        for(int i=0; i<width; i++){
            myList.get(i);
        }

        // 좌우 빈곳 위치 찾아서 제거하기

        sc.close();
    }
}
