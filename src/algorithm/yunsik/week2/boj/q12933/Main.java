package algorithm.yunsik.week2.boj.q12933;

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    static final char[] seq = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : br.readLine().toCharArray()) {
            deque.addLast(c);
        }

        int size = deque.size();
        int ans = 0, prev;
        do {
            int cnt = 0;
            int idx = 0;
            prev = size;
            while (size-- > 0) {
                Character first = deque.removeFirst();
                if (first == seq[idx]) {
                    if (++idx == 5) {
                        cnt++;
                        idx %= 5;
                    }
                } else {
                    deque.addLast(first);
                }
            }
            for (int i = 0; i < idx; i++) {
                deque.addLast(seq[i]);
            }
            if (cnt > 0) ans++;
            size = deque.size();
        } while (prev != size);

        if (ans == 0 || size != 0) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
