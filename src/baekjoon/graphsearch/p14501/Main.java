package baekjoon.graphsearch.p14501;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int maxProfit = 0;
    static int [][] interview;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        interview = new int[N+1][2];

        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            interview[i][0] = Integer.parseInt(st.nextToken());
            interview[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(1,0);
        System.out.print(maxProfit);
    }

    static void dfs(int day, int sum) {
        if (day >= N + 1) {
            maxProfit = Math.max(maxProfit, sum);
            return;
        }

        if (day + interview[day][0] <= N + 1) {
            dfs(day + interview[day][0], sum + interview[day][1]);
        }
        dfs(day + 1, sum);
    }
}
