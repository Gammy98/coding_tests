package baekjoon.stack.p1874;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] st = new int[100005];
    static int cur = 0;
    static int top_value = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();
            if (target > top_value) {
                for (int j = top_value + 1; j <= target; j++) {
                    push(j);
                    sb.append("+\n");
                }
                top_value = target;
            }
            if (st[cur - 1] != target) {
                System.out.println("NO");
                System.exit(0);
            }
            pop();
            sb.append("-\n");
        }
        System.out.print(sb);
    }

    static void push(int num) {
        st[cur++] = num;
    }

    static void pop() {
        if (cur > 0) {
            cur --;
        }
    }
}
