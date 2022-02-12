package algorithm.jungin.etc.q2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static int[] d = new int[6];
    static int[] length = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        int[] cnt = new int[5];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());
            cnt[d[i]] += 1;
        }

        if (cnt[2] == 1 && cnt[4] == 1) {
            System.out.println(getArea(4));
        } else if (cnt[2] == 1 && cnt[3] == 1) {
            System.out.println(getArea(2));
        } else if (cnt[1] == 1 && cnt[3] == 1) {
            System.out.println(getArea(3));
        } else if (cnt[1] == 1 && cnt[4] == 1) {
            System.out.println(getArea(1));
        }
    }

    public static int getArea(int start) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if (d[i] == start) {
                while (list.size() != 6) {
                    list.add(length[i++]);
                    if (i == 6)
                        i = 0;
                }
                break;
            }
        }
        return k * (list.get(0) * list.get(1) - list.get(3) * list.get(4));
    }
}
