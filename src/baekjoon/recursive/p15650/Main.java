package baekjoon.recursive.p15650;

import java.util.*;

public class Main {
    static int N,M;
    static StringBuilder ans = new StringBuilder();
    static int[] arr;
    static boolean[] isUsed;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        isUsed = new boolean[N+1];

        solve(0,1);
        System.out.println(ans);
    }

    public static void solve(int depth, int start){
        if (depth==M) {
            for (int i : arr) {
                ans.append(i);
                ans.append(" ");
            }
            ans.append("\n");
            return;
        }
        for (int j = start; j < N+1; j++) {
            if (!isUsed[j]) {
                arr[depth] = j;
                isUsed[j] = true;
                solve(depth + 1, j+1);
                isUsed[j] = false;
            }
        }

    }
}
