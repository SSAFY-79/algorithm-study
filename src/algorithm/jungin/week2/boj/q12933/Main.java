package algorithm.jungin.week2.boj.q12933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Stack<Character>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        list.add(new Stack<>());
        if (s.charAt(0) == 'q')
            list.get(0).add('q');
        else {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'q':
                    boolean flag = false;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).peek() == 'k') {
                            list.get(j).add('q');
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        list.add(new Stack<>());
                        list.get(list.size() - 1).add('q');
                    }
                    break;
                case 'u':
                    if (!checkStack('q', 'u'))
                        return;
                    break;

                case 'a':
                    if (!checkStack('u', 'a'))
                        return;
                    break;

                case 'c':
                    if (!checkStack('a', 'c'))
                        return;
                    break;

                case 'k':
                    if (!checkStack('c', 'k'))
                        return;
                    break;

            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() % 5 != 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(list.size());
    }

    private static boolean checkStack(char compare, char input) {
        boolean flag = false;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).peek() == compare) {
                list.get(j).add(input);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
            return false;
        }
        return true;
    }
}