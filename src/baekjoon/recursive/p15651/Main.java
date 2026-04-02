package baekjoon.recursive.p15651;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {

        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];

        solve(0);
        System.out.print(ans);
    }

    static void solve(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                ans.append(arr[i]).append(" ");
            }
            ans.append("\n");
            return;
        }
        for (int i = 1; i < N+1; i++) {
            arr[k] = i;
            solve(k+1);
        }
    }
}
