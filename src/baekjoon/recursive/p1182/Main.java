package baekjoon.recursive.p1182;

import java.io.*;
import java.util.*;

public class Main {
    static int N,S;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0,0);
        if (S == 0) {
            cnt --; //공집함 하나 빼줌, 문제에서 부분집합원소의개수가 양수라 했으므로
        }
        System.out.print(cnt);
    }

    static void solve(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        solve(idx + 1, sum + arr[idx]); //현재포함
        solve(idx + 1, sum); //현재 포함 X
    }
}
