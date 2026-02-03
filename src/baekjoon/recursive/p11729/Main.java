package baekjoon.recursive.p11729;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        sb.append((1 << N) - 1 + "\n");
        hanoi(1,3,N); //최종적으로 1번에서 3번으로 옮겨라
        System.out.print(sb);

    }

    static void hanoi(int a, int b, int n) {
        if (n == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }
        hanoi(a, 6 - a - b, n - 1);

        sb.append(a + " " + b + "\n");
        hanoi(6 - a - b, b, n - 1);
    }
}
