package baekjoon.graphsearch.p9466__;

import java.io.*;
import java.util.*;

public class Main {
    static int n,cnt;
    static int[] nxt;
    static boolean[] visited,finished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            n = Integer.parseInt(br.readLine());
            nxt = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) nxt[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (!visited[i]){
                    dfs(i);
                }
            }
            System.out.println(n - cnt);

        }
    }

    static void dfs(int curr) {
        visited[curr] = true;
        int next = nxt[curr];

        if (!visited[next]) { //재귀 > dfs
            dfs(next);
        } else if (!finished[next]) {
            //사이클 발견
            for (int i = next; i != curr; i = nxt[i]) {
                cnt++;
            }
            cnt ++; //자신포함
        }
        finished[curr] = true; // 탐색 끝
    }
}
