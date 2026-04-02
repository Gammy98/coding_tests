package baekjoon.recursive.p15652;

import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) {

        //입력과 초기화
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];

        solve(1,0);
        System.out.print(ans);
    }

    static void solve(int idx, int k) {
        if (k == M) {
            for (int i : arr) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }
        for (int i = idx; i < N+1; i++) {
            arr[k] = i;
            solve(i, k + 1);
        }
    }
}
