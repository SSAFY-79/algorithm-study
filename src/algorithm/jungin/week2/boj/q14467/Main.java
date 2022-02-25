package algorithm.jungin.week2.boj.q14467;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] info = new int[11];
        Arrays.fill(info, -1);
        int cow, index, sum = 0;
        for (int i = 0; i < n; i++) {
            cow = sc.nextInt();
            index = sc.nextInt();
            if (info[cow] == -1)
                info[cow] = index;
            else if (info[cow] == index)
                continue;
            else {
                sum += 1;
                info[cow] = index;
            }
        }
        System.out.println(sum);
    }
}
