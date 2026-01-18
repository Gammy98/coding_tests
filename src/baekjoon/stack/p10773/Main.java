package baekjoon.stack.p10773;

import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] st = new int[100005];
    static int cur = 0;
    static int sum = 0;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        K = Integer.parseInt(sc.next());

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(sc.next());
            if (cur > 0 && num == 0) {
                sum -= st[cur-1];
                st[cur-1] = 0;
                cur --;
            }

            else {
                st[cur] = num;
                sum += num;
                cur ++;
            }
        }
        System.out.print(sum);
    }

}
