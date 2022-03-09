package algorithm.kwangwoo.week5.boj.q23309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static String code;
    static int firstInput;
    static int secondInput;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Info> map = new HashMap<Integer, Info>();

    static class Info {
        int pre;
        int next;

        public Info(int pre, int next) {
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringTokenizer st;

        // N M 입력
        input = in.readLine();
        st = new StringTokenizer(input, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 노드들 입력
        input = in.readLine();
        st = new StringTokenizer(input, " ");

        // 처음 노드
        int first = Integer.parseInt(st.nextToken());
        map.put(first, new Info(0, 0));

        // 중간 노드들
        int cur = first;
        int pre = cur;
        for (int i = 1; i < (N - 1); i++) {
            cur = Integer.parseInt(st.nextToken());
            map.put(cur, new Info(pre, 0));
            map.get(pre).next = cur;
            pre = cur;
        }

        // 마지막 노드
        cur = Integer.parseInt(st.nextToken());
        map.put(cur, new Info(pre, first));
        map.get(pre).next = cur;

        // 마지막 노드와 처음노드 연결
        map.get(first).pre = cur;

        // ----------------------------------

        for (int i = 0; i < M; i++) {
            input = in.readLine();
            st = new StringTokenizer(input, " ");
            code = st.nextToken();
            firstInput = Integer.parseInt(st.nextToken());
            if (code.charAt(0) == 'B') {
                secondInput = Integer.parseInt(st.nextToken());
            }

            // 처리
            func();
        }
        System.out.println(sb.toString());

        // for (int key : map.keySet()) {

        // Info value = map.get(key);

        // System.out.println(key + " : " + value.pre + ", " + value.next);

        // }
    }

    static void func() {
        // 고유번호의 info
        Info curInfo = map.get(firstInput);

        if (code.equals("BN")) {
            // 출력
            sb.append(curInfo.next + "\n");

            // 새 노드 추가
            map.put(secondInput, new Info(firstInput, curInfo.next));

            // 다음노드.pre, 이전노드.next 수정
            map.get(curInfo.next).pre = secondInput;
            curInfo.next = secondInput;

        } else if (code.equals("BP")) {
            // 출력
            sb.append(curInfo.pre + "\n");

            // 새 노드 추가
            map.put(secondInput, new Info(curInfo.pre, firstInput));

            // 이전노드.next, 현재노드.pre 수정
            map.get(curInfo.pre).next = secondInput;
            curInfo.pre = secondInput;

        } else if (code.equals("CN")) {
            // 출력
            sb.append(curInfo.next + "\n");

            // 값이 덮어씌워지기 때문에, 삭제할 값 따로 저장
            int willRemove = curInfo.next;

            // 다음다음노드.pre, 현재노드.next 수정
            map.get(map.get(curInfo.next).next).pre = firstInput;
            curInfo.next = map.get(curInfo.next).next;

            // 삭제
            map.remove(willRemove);

        } else if (code.equals("CP")) {
            // 출력
            sb.append(curInfo.pre + "\n");

            // 값이 덮어씌워지기 때문에, 삭제할 값 따로 저장
            int willRemove = curInfo.pre;

            // 전전노드.next, 현재노드.pre 수정
            map.get(map.get(curInfo.pre).pre).next = firstInput;
            curInfo.pre = map.get(curInfo.pre).pre;

            // 노드 삭제
            map.remove(willRemove);
        }
    }
}
