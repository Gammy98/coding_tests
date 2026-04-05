package baekjoon.graphsearch.p14889;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] team;
    static boolean[] isVisited;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];
        team = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.print(minDiff);
    }

    static void dfs(int cnt, int start) {
        if (cnt == N / 2) {
            calculate();  // 차이계산
            return;
        }

        // 팀짜기
        for (int i = start; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(cnt+1, i+1);
                isVisited[i] = false;
            }
        }

    }

    static void calculate() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    sum1 += team[i][j] + team[j][i];
                } else if (!isVisited[i] && !isVisited[j]) {
                    sum2 += team[i][j] + team[j][i];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
        if (minDiff == 0) {
            System.out.print(0);
            System.exit(0);
        }
    }
}
