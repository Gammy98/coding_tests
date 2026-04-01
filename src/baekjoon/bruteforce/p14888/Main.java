package baekjoon.bruteforce.p14888;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] cal = new int[4];
    static int maxAns = Integer.MIN_VALUE;
    static int minAns = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        solve(arr[0],1);
        System.out.println(maxAns);
        System.out.println(minAns);

    }

    public static void solve(int currentSum, int k) {
        if (k == N) {
            maxAns = Math.max(maxAns, currentSum);
            minAns = Math.min(minAns, currentSum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                if (i == 0) {
                    solve(currentSum + arr[k], k + 1);
                } else if (i == 1) {
                    solve(currentSum - arr[k], k + 1);
                }else if (i == 2) {
                    solve(currentSum * arr[k], k + 1);
                }else if (i == 3) {
                    solve(currentSum / arr[k], k + 1);
                }

                cal[i]++; //백트래킹
            }
        }
    }

}
