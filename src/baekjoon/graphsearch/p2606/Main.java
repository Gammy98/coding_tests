package baekjoon.graphsearch.p2606;

import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] link;
    static boolean[] isVisited;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        link = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }
        isVisited = new boolean[N+1];


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            link[x].add(y);
            link[y].add(x);
        }

        dfs(1);
        System.out.print(sum - 1);

    }

    static void dfs(int current) {
        isVisited[current] = true;
        sum++;

        for (int next : link[current]) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }
}
