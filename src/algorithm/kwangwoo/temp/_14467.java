package algorithm.kwangwoo.temp;

import java.util.HashMap;
import java.util.Scanner;

class _14467{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int cnt = 0;
            
        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            // 처음 확인되는 소 인 경우
            if(map.get(x) == null){
                map.put(x, y);
            }else{
                if(map.get(x) != y){
                    cnt++;
                    map.put(x, y);
                }
            }

        }

        System.out.println(cnt);

        sc.close();
    }
}