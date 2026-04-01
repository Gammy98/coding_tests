package baekjoon.recursive.p15649;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;  //숫자 담을 배열
    static boolean[] isUsed; //사용여부 체크
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N + 1];

        solve(0);
        System.out.print(ans);
    }

    public static void solve(int k){
        if (k == M) {
            for (int i : arr) {
                ans.append(i).append(" ");
            }
            ans.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                solve(k + 1);
                isUsed[i] = false; //백트래킹
            }
        }
    }
}
